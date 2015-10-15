package ch4.cbc.xuewei.ece.cmu;

import java.util.LinkedList;

public class Solution41 {
	public static boolean routeBetweenNodes(GraphNode<Integer> start,
			GraphNode<Integer> end) {
		if (start == end) {
			return true;
		}

		// use LinkedList as a queue
		LinkedList<GraphNode<Integer>> queue = new LinkedList<GraphNode<Integer>>();

		// initialize the first node's state to visiting
		start.setState(GraphNodeState.Visiting);
		// add the first point to the queue
		queue.add(start);
		
		// process every node in the queue, 
		// and add every neighbor of current node to the queue
		while (!queue.isEmpty()) {
			
			GraphNode<Integer> current = queue.remove();
			if (current != null) {
				// process every neighbors, all neighbors that haven't been visited 
				// will be added in the queue. 
				// once find the target node, directly return true;
				for (GraphNode<Integer> node : current.getNeighbors()) {
					if (node.getState() == GraphNodeState.Unvisited) {
						// route found
						if (node == end) {
							return true;
						} 
						// add unvisited neighbors
						else {
							node.setState(GraphNodeState.Visiting);
							queue.add(node);
						}
					}
				}
				// update the state of a visited node.
				current.setState(GraphNodeState.Visited);
			}
		}
		return false;

	}

	public static void main(String[] args) {
	}

}
