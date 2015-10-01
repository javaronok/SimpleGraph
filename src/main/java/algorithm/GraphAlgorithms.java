package algorithm;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Dmitriy
 * Date: 30.09.2015
 * Time: 11:53
 */
public class GraphAlgorithms {
  public static final Class<? extends GraphAlgorithm> ALGORITHM_CLASS_DFS = DFSGraphAlgorithm.class;
  public static final Class<? extends GraphAlgorithm> ALGORITHM_CLASS_BFS = BFSGraphAlgorithm.class;

  public static final Class<? extends GraphAlgorithm> ALGORITHM_CLASS_DEFAULT = DFSGraphAlgorithm.class;

  private static Map<String, Class<? extends GraphAlgorithm>> registeredNamedAlgorithms = new HashMap<String, Class<? extends GraphAlgorithm>>();

  public static Class<? extends GraphAlgorithm> lookupAlgorithmClass(String algName) {
    if (algName == null)
      throw new IllegalArgumentException("Algorithm name is empty");

    Class<? extends GraphAlgorithm> alg = registeredNamedAlgorithms.get(algName);
    if (alg == null)
      throw new IllegalArgumentException("Algorithm not supported");

    return alg;
  }

  public static GraphAlgorithm createAlgorithm(Class<? extends GraphAlgorithm> alg) {
    if (alg == null) throw new IllegalArgumentException("Algorithm not found");
    try {
      Constructor<? extends GraphAlgorithm> constructor = alg.getConstructor();
      return constructor.newInstance();
    } catch (Exception e) {
      final String message = e.getMessage();
      throw new RuntimeException(
              (message == null ? "" : message) + "\n(Instantiating new algorithm class instance: " + alg.getName() + ')', e);
    }
  }

  static {
    registeredNamedAlgorithms.put(DFSGraphAlgorithm.ALG_NAME, ALGORITHM_CLASS_DFS);
    registeredNamedAlgorithms.put(BFSGraphAlgorithm.ALG_NAME, ALGORITHM_CLASS_BFS);
  }
}
