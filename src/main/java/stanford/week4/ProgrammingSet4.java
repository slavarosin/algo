package stanford.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.junit.Test;

public class ProgrammingSet4 {
	private static final int N = 875715;

	Integer[] f = new Integer[N];

	Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

	Integer[] leader = new Integer[N];

	Map<Integer, List<Integer>> rGraph = new HashMap<Integer, List<Integer>>();

	Integer s = null;

	int t = 0;

	boolean[] visited = new boolean[N];

	private Map<Integer, List<Integer>> changeGraphToFinishingTimes(final Map<Integer, List<Integer>> g,
			final Integer[] f2) {
		Map<Integer, List<Integer>> g2 = new HashMap<Integer, List<Integer>>();

		Iterator<Integer> iter = g.keySet().iterator();
		while (iter.hasNext()) {
			Integer key = iter.next();
			List<Integer> values = g.get(key);

			Integer newKey = f[key];
			ArrayList<Integer> newValues = new ArrayList<Integer>();
			for (Integer v : values) {
				newValues.add(f[v]);
			}

			g2.put(newKey, newValues);
		}

		return g2;
	}

	private String computeSCC() {
		DFSLoop(rGraph);

		graph = changeGraphToFinishingTimes(graph, f);

		f = new Integer[N];
		leader = new Integer[N];
		s = null;
		visited = new boolean[N];

		DFSLoop(graph);

		return formatOutput(leader);
	}

	private void DFSLoop(final Map<Integer, List<Integer>> g) {
		for (int i = N - 1; i > 0; i--) {
			if (!visited[i]) {
				s = i;
				DFSLoop(g, i);
			}
		}
	}

	private void DFSLoop(final Map<Integer, List<Integer>> g, final Integer i) {
		visited[i] = true;
		leader[i] = s;

		List<Integer> edges = g.get(i);
		if (edges != null) {
			for (Integer j : edges) {
				if (!visited[j]) {
					DFSLoop(g, j);
				}
			}
		}

		f[i] = ++t;
	}

	private String formatOutput(Integer[] leader) {
		leader = Arrays.copyOfRange(leader, 1, leader.length);

		Integer[] top = new Integer[N];

		for (int i : leader) {
			if (top[leader[i - 1]] == null) {
				top[leader[i - 1]] = 0;
			}
			top[leader[i - 1]]++;
		}

		Arrays.sort(top, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == null) {
					o1 = 0;
				}
				if (o2 == null) {
					o2 = 0;
				}
				return o2.compareTo(o1);
			}
		});

		String formatted = "";
		for (int i = 0; i < 5; i++) {
			int f = 0;
			if (top[i] != null) {
				f = top[i];
			}

			formatted += f + ",";
		}
		return formatted.substring(0, formatted.length() - 1);
	}

	@Test
	public void programmingSet4() throws IOException {
		readGraph();

		System.out.println(computeSCC());
	}

	private LinkedList<Integer> readEdge(final String line) {
		StringTokenizer tokenizer = new StringTokenizer(line);

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(Integer.parseInt(tokenizer.nextToken()));
		list.add(Integer.parseInt(tokenizer.nextToken()));

		return list;
	}

	private void readGraph() throws IOException {
		InputStream is = ProgrammingSet4.class.getResourceAsStream("SCC.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		graph = new HashMap<Integer, List<Integer>>();
		rGraph = new HashMap<Integer, List<Integer>>();

		String l = null;
		while ((l = reader.readLine()) != null) {
			LinkedList<Integer> line = readEdge(l);

			List<Integer> edges = graph.get(line.getFirst());
			if (edges == null) {
				edges = new ArrayList<Integer>();
				graph.put(line.getFirst(), edges);
			}
			edges.add(line.getLast());

			List<Integer> rEdges = rGraph.get(line.getLast());
			if (rEdges == null) {
				rEdges = new ArrayList<Integer>();
				rGraph.put(line.getLast(), rEdges);
			}
			rEdges.add(line.getFirst());
		}

		reader.close();
	}
}
