package Question2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Objects;

class Vertex {
	private String id;
	private String name;

	public Vertex(String id, String name) {
		// Your code here
		this.id =id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		return Objects.equals(id, other.id);
	}

	
}

public class Graph {
	private Set<Vertex> vertices;
	private Map<Vertex, Set<Vertex>> adjacencyList;

	public Graph() {
		this.vertices = new HashSet<>();
		this.adjacencyList = new HashMap<>();
	}

	public void addVertex(Vertex vertex) {
		// You
		vertices.add(vertex);
		Set<Vertex> set = new HashSet<>();
		adjacencyList.put(vertex,set);
	}

	public boolean addEdge(Vertex source, Vertex destination) {
	    if (!vertices.contains(source) || !vertices.contains(destination)) {
	        return false; 
	    }
	    return adjacencyList
	            .computeIfAbsent(source, k -> new HashSet<>())
	            .add(destination);
	}

	public boolean removeVertex(Vertex vertex) {
		// Your code here
		if(vertex == null)
		return false;
		vertices.remove(vertex);
		Set<Vertex> list = adjacencyList.keySet();
		for(Vertex v :list)
		{
				Set<Vertex> set = adjacencyList.get(v);
				if(set.contains(vertex)) {
					set.remove(vertex);
					adjacencyList.put(v, set);
					return true;
				}
			
		}
		return false;
	}

	public Set<Vertex> getNeighbors(Vertex vertex) {
		if(vertex == null)
			return null;
		return adjacencyList.get(vertex);
	}

	public int getVertexCount() {
		return vertices.size();
	}
}