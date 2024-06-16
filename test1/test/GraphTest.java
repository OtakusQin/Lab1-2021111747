/*import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void calcShortestPath() {
    }
}*/
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GraphTest {
    private Graph graph;
    @Before

    public void setUp() {
        graph = new Graph();
        Map<String, Map<String, Integer>> adjList = new HashMap<>();

        // 设置图的邻接表
        adjList.put("a", Map.of("b", 1));
        adjList.put("b", Map.of("a", 1, "c", 2));
        adjList.put("c", Map.of("b", 2));
        adjList.put("d", new HashMap<>());
        adjList.put("e", new HashMap<>());
        graph.setAdjList(adjList);
    }

    @Test
    public void testCalcShortestPath_ValidPath() {
        String result = graph.calcShortestPath("a", "c");
        assertEquals("Shortest path from a to c is: a b c. Path length: 3.", result);
    }

    @Test
    public void testCalcShortestPath_NoPath() {
        String result = graph.calcShortestPath("a", "e");
        assertEquals("No path from a to e!", result);
    }

    @Test
    public void testCalcShortestPath_SameNode() {
        String result = graph.calcShortestPath("a", "a");
        assertEquals("Shortest path from a to a is: a. Path length: 0.", result);
    }

    @Test
    public void testCalcShortestPath_NodeNotInGraph1() {
        String result = graph.calcShortestPath("x", "a");
        assertEquals("No x or a in the graph!", result);
    }

    @Test
    public void testCalcShortestPath_NodeNotInGraph2() {
        String result = graph.calcShortestPath("a", "y");
        assertEquals("No a or y in the graph!", result);
    }

    @Test
    public void testCalcShortestPath_NodeNotInGraph3() {
        String result = graph.calcShortestPath("x", "y");
        assertEquals("No x or y in the graph!", result);
    }

    @Test
    public void testCalcShortestPath_BoundaryCondition() {
        // 单条边的图
        graph = new Graph();
        Map<String, Map<String, Integer>> adjList = new HashMap<>();
        adjList.put("a", Map.of("b", 1));
        adjList.put("b", Map.of("a", 1));
        graph.setAdjList(adjList);

        String result = graph.calcShortestPath("a", "b");
        assertEquals("Shortest path from a to b is: a b. Path length: 1.", result);
    }
}