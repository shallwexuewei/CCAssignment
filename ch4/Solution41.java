package ch4.cbc.xuewei.ece.cmu;

import java.util.LinkedList;

public class Solution41 {
	public static boolean routeBetweenNodes(GraphNode<Integer> start,
			GraphNode<Integer> end) {
		if (start == end) {
			return true;
		}

		LinkedList<GraphNode<Integer>> queue = new LinkedList<GraphNode<Integer>>();

		start.setState(GraphNodeState.Visiting);
		queue.add(start);
		while (!queue.isEmpty()) {
			GraphNode<Integer> temp = queue.remove();
			if (temp != null) {
				for (GraphNode<Integer> node : temp.getNeighbors()) {
					if (node.getState() == GraphNodeState.Unvisited) {
						if (node == end) {
							return true;
						} else {
							node.setState(GraphNodeState.Visiting);
							queue.add(node);
						}
					}
				}
				temp.setState(GraphNodeState.Visited);
			}
		}
		return false;

	}

	public static void main(String[] args) {
	}

}
