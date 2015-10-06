package ch4.cbc.xuewei.ece.cmu;

import java.util.ArrayList;

public class Solution47 {
	public static Project[] buildOrder(ArrayList<Project> projects) {
		Project[] result = new Project[projects.size()];

		int lastIndex = addNextProjects(result, projects, 0);
		int i = 0;
		while (i < result.length) {
			Project current = result[i];

			// exception -- if null found, return null
			if (current == null) {
				return null;
			}

			// delete current node from the original graph to
			// to free all projects that are dependent on it.
			ArrayList<Project> children = current.getChildren();
			for (Project child : children) {
				child.decrementDependencies();
			}

			// choose the projects without numberDependencies in children to add
			// in
			// the result
			lastIndex = addNextProjects(result, children, lastIndex);

			i++;
		}
		return result;
	}

	public static int addNextProjects(Project[] result,
			ArrayList<Project> candidates, int lastIndex) {
		for (Project project : candidates) {
			// add the projects without numberDependencies into result
			if (project.getNumberDependencies() == 0) {
				result[lastIndex] = project;
				lastIndex++;
			}
		}
		return lastIndex;
	}

	public static class Project {
		private ArrayList<Project> children = new ArrayList<Project>();
		private String name;
		private int numberDependencies = 0;

		public Project(String str) {
			name = str;
		}

		public void addDependency(Project parent) {
			parent.addChildren(this);
		}

		public void addChildren(Project child) {
			children.add(child);
			child.incrementDependencies();
		}

		public void incrementDependencies() {
			numberDependencies++;
		}

		public void decrementDependencies() {
			numberDependencies--;
		}

		public String getName() {
			return name;
		}

		public ArrayList<Project> getChildren() {
			return children;
		}

		public int getNumberDependencies() {
			return numberDependencies;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Project a = new Project("a");
		Project b = new Project("b");
		Project c = new Project("c");
		Project d = new Project("d");
		Project e = new Project("e");
		Project f = new Project("f");
		d.addDependency(a);
		b.addDependency(f);
		d.addDependency(b);
		a.addDependency(f);
		c.addDependency(d);
		ArrayList<Project> projects = new ArrayList<Solution47.Project>();
		projects.add(a);
		projects.add(b);
		projects.add(c);
		projects.add(d);
		projects.add(e);
		projects.add(f);
		Project[] result = buildOrder(projects);
		for (Project proj : result) {
			System.out.print(proj.getName());
			System.out.print(' ');
		}
		System.out.println();

	}

}
