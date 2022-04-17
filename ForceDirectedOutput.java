public class ForceDirectedOutput {
  //constant repulsive factor
  private static final double REPULSIVE_FACTOR = 2.0;
  //constant spring factor
  private static final double SPRING_FACTOR = 1.0;
  //constant spring length
  private static final double SPRING_LENGTH = 1.0;
  //constant cooling factor
  private static final double COOLING_FACTOR = 0.99;
  //constant threshold for stopping
  private static final double THRESHOLD = 0.1;
  //constant number of iterations
  private static final int ITERATIONS = 1000;

  double repulsiveForce(CS400Graph.Vertex v1, CS400Graph.Vertex v2) {
    return 0;
  }
  double attractiveForce(CS400Graph.Vertex v1, CS400Graph.Vertex v2) {
    return springForce(v1, v2) - repulsiveForce(v1, v2);
  }

  double springForce(CS400Graph.Vertex v1, CS400Graph.Vertex v2) {
    return 0;
  }

  double euclideanDistance(CS400Graph.Vertex v1, CS400Graph.Vertex v2) {
    return 0;
  }

  Object displacementVector(CS400Graph.Vertex v) {
    return null;
    //sum of attractive forces on v with al other vertices - sum of repulsive forces on v with al other vertices

  }

  CS400Graph.Edge timesVector(double scalar, CS400Graph.Edge e) {
    return null;
  }
}
