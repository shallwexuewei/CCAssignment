package ch4.cbc.xuewei.ece.cmu;

import java.util.ArrayList;

public class DirectedGraph<T> {
	public ArrayList<GraphNode<T>> nodes;

	public DirectedGraph() {
		this.nodes = new ArrayList<GraphNode<T>>();
	}

	public DirectedGraph(ArrayList<GraphNode<T>> nodes) {
		this.nodes = nodes;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
