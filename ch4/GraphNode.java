package ch4.cbc.xuewei.ece.cmu;

import java.util.ArrayList;

public class GraphNode<T> {
	private T value;
	private ArrayList<GraphNode<T>> neighbors;
	private GraphNodeState state;

	public GraphNode(T value) {
		super();
		this.value = value;
		this.neighbors = new ArrayList<GraphNode<T>>();
		this.state = GraphNodeState.Unvisited;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public ArrayList<GraphNode<T>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<GraphNode<T>> neighbors) {
		this.neighbors = neighbors;
	}

	public GraphNodeState getState() {
		return state;
	}

	public void setState(GraphNodeState state) {
		this.state = state;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
