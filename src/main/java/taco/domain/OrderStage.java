package taco.domain;

public enum OrderStage {
  PLACED,       // Order has been placed
  PREPARING,    // Order is being prepared in the kitchen
  READY,        // Order is ready to be picked up or delivered
  DELIVERED,    // Order has been delivered (or picked up)
  CANCELLED,    // Order has been cancelled
  COMPLETED;    // Order has been completed successfully (food delivered and received)
}
