package misc;

public class CircuitBreaker {

    private enum State { CLOSED, OPEN, HALF_OPEN }

    private State currentState = State.CLOSED;
    private int failureThreshold;
    private long retryTimePeriod;
    private int failureCount = 0;
    private long lastFailureTime = 0;

    public CircuitBreaker(int failureThreshold, long retryTimePeriod) {
        this.failureThreshold = failureThreshold;
        this.retryTimePeriod = retryTimePeriod;
    }

    public <T> T execute(ServiceCall<T> serviceCall) throws CircuitBreakerOpenException {
        if (currentState == State.OPEN) {
            if (System.currentTimeMillis() - lastFailureTime < retryTimePeriod) {
                throw new CircuitBreakerOpenException("Circuit breaker is open. Service unavailable.");
            } else {
                currentState = State.HALF_OPEN;
            }
        }

        try {
            T result = serviceCall.call();
            reset(); // Success, reset the circuit
            return result;
        } catch (Exception e) {
            handleFailure();
            throw new CircuitBreakerOpenException(e); // Rethrow the original exception
        }
    }

    private void handleFailure() {
        failureCount++;
        lastFailureTime = System.currentTimeMillis();

        if (failureCount >= failureThreshold) {
            currentState = State.OPEN;
        }
    }

    private void reset() {
        failureCount = 0;
        currentState = State.CLOSED;
    }

    public State getState() {
        return currentState;
    }

    public interface ServiceCall<T> {
        T call() throws Exception;
    }

    public static class CircuitBreakerOpenException extends Exception {
        public CircuitBreakerOpenException(String message) {
            super(message);
        }

        public CircuitBreakerOpenException(Throwable e) {
            super(e);
        }
    }

    public static void main(String[] args) {
        CircuitBreaker breaker = new CircuitBreaker(3, 5000); // 3 failures, 5 seconds retry

        ServiceCall<String> service = () -> {
            // Simulate a service call that sometimes fails
            if (Math.random() < 0.2) { // 20% chance of failure
                throw new RuntimeException("Service failure");
            }
            return "Service response";
        };

        for (int i = 0; i < 10; i++) {
            try {
                String result = breaker.execute(service);
                System.out.println("Result: " + result);
            } catch (CircuitBreakerOpenException e) {
                System.out.println("Circuit breaker open: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Service failed: " + e.getMessage());
            }

            try {
                Thread.sleep(1000); // Wait for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
