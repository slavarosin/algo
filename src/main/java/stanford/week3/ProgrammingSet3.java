package stanford.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import org.junit.Assert;
import org.junit.Test;

public class ProgrammingSet3 {
	Map<String, List<String>> graph = new HashMap<String, List<String>>();

	int n = 40, m = 0;

	private int findMinCut() {
		while (n > 2) {
			randomlyCut();
		}

		return graph.values().iterator().next().size();
	}

	private void mergeAndDeleteSelfLoops(final String nodeA, final String nodeB) {
		List<String> fromNodeA = graph.get(nodeA);
		List<String> fromNodeB = graph.get(nodeB);

		// Change links from NodeB to NodeA
		for (String i : fromNodeB) {
			graph.get(i).remove(nodeB);
			graph.get(i).add(nodeA);
		}

		// Add all NodeB links to NodeA
		fromNodeA.addAll(fromNodeB);

		// Delete self-loops
		Iterator<String> iter = fromNodeA.iterator();
		while (iter.hasNext()) {
			String i = iter.next();
			if (i.equals(nodeA)) {
				iter.remove();
			}
		}

		// Remove NodeB from graph
		graph.remove(nodeB);
	}

	private void randomlyCut() {
		Random random = new Random();

		Integer a = random.nextInt(n);
		String nodeA = (String) graph.keySet().toArray()[a];
		List<String> fromNodeA = graph.get(nodeA);
		Integer b = random.nextInt(fromNodeA.size());
		String nodeB = fromNodeA.get(b);

		mergeAndDeleteSelfLoops(nodeA, nodeB);

		n--;
	}

	private LinkedList<String> readAdjacencyList(final String line) {
		StringTokenizer tokenizer = new StringTokenizer(line);

		LinkedList<String> list = new LinkedList<String>();
		while (tokenizer.hasMoreTokens()) {
			list.add(tokenizer.nextToken());
		}

		m += list.size() - 1;

		return list;
	}

	private void readGraph() throws IOException {
		InputStream is = ProgrammingSet3.class.getResourceAsStream("kargerAdj.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		graph = new HashMap<String, List<String>>();
		m = 0;

		String l = null;
		while ((l = reader.readLine()) != null) {
			LinkedList<String> line = readAdjacencyList(l);
			graph.put(line.getFirst(), line.subList(1, line.size()));
		}

		n = graph.size();

		Assert.assertEquals("[19, 15, 36, 23, 18, 39]", graph.get("1").toString());
		Assert.assertEquals(188, m);

		reader.close();
	}

	@Test
	public void test() throws IOException {
		int minCut = n;

		for (int i = 0; i < 100; i++) {
			readGraph();
			minCut = Math.min(findMinCut(), minCut);
		}

		Assert.assertSame(3, minCut);
	}
}
