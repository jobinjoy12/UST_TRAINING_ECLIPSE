//package Question2;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//import java.util.Objects;
//
//class Task {
//	private String id;
//	private String description;
//	private String status;
//
//	public String getId() {
//		return id;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Task other = (Task) obj;
//		return Objects.equals(id, other.id);
//	}
//
//	public Task(String id, String description, String status) {
//		super();
//		this.id = id;
//		this.description = description;
//		this.status = status;
//	}
//}
//
//class Project {
//	private String projectId;
//	private String name;
//	private Set<Task> tasks;
//
//	public Project(String projectId, String name, Set<Task> tasks) {
//		super();
//		this.projectId = projectId;
//		this.name = name;
//		this.tasks = tasks;
//	}
//
//	public String getProjectId() {
//		return projectId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public Set<Task> getTasks() {
//		return tasks;
//	}
//
//	public Optional<Task> getTaskById(String taskId) {
//		if (taskId == null) {
//			return Optional.empty();
//		}
//		for (Task task : tasks) {
//			if (task.getId().equals(taskId)) {
//				return Optional.of(task);
//			}
//		}
//		return Optional.empty();
//	}
//
//	public boolean addTask(Task task) {
//		return tasks.add(task);
//	}
//
//	public boolean removeTask(String taskId) {
//		Optional<Task> taskToRemove = getTaskById(taskId);
//		if (taskToRemove.isPresent()) {
//			return tasks.remove(taskToRemove.get());
//		}
//		return false;
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		Project project = (Project) o;
//		return Objects.equals(projectId, project.projectId);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(projectId);
//	}
//}
//
//public class ProjectManagementSystem {
//	private Set<Project> projects;
//
//	public ProjectManagementSystem() {
//		this.projects = new HashSet<>();
//	}
//
//	public boolean addProject(Project project) {
//		return projects.add(project);
//	}
//
//	public boolean removeProject(String projectId) {
//		for (Project p : projects) {
//			if (p.getProjectId().equals(projectId)) {
//				return projects.remove(p);
//			}
//		}
//		return false;
//	}
//
//	public boolean addTaskToProject(String projectId, Task task) {
//		for (Project p : projects) {
//			if (p.getProjectId().equals(projectId)) {
//				return p.addTask(task);
//			}
//		}
//		return false;
//	}
//
//	public boolean updateTaskStatus(String projectId, String taskId, String newStatus) {
//		for (Project p : projects) {
//			if (p.getProjectId().equals(projectId)) {
//				Optional<Task> task = p.getTaskById(taskId);
//				if (task.isPresent()) {
//					task.get().setStatus(newStatus);
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//
//	public Set<Task> getProjectTasks(String projectId) {
//		for (Project p : projects) {
//			if (p.getProjectId().equals(projectId)) {
//				return p.getTasks();
//			}
//		}
//		return new HashSet<>();
//	}
//}

package Question2;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Objects;

class Task {
    private String id;
    private String description;
    private String status;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        Task other = (Task) obj;
        return Objects.equals(id, other.id);
    }

    public Task(String id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }
}

class Project {
    private String projectId;
    private String name;
    private Set<Task> tasks; // As per requirement, using Set<Task>

    // Constructor to align with test cases (2 arguments)
    public Project(String projectId, String name) {
        this.projectId = projectId;
        this.name = name;
        this.tasks = new HashSet<>(); // Initialize an empty set
    }

    // Overloaded constructor for initial tasks (3 arguments), ensuring deep copy/isolation
    public Project(String projectId, String name, Set<Task> initialTasks) {
        this(projectId, name); // Call the 2-arg constructor
        if (initialTasks != null) {
            this.tasks.addAll(initialTasks);
        }
    }

    public String getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    // Encapsulation improvement: Return an unmodifiable view of the tasks
    public Set<Task> getTasks() {
        return Collections.unmodifiableSet(tasks);
    }

    public Optional<Task> getTaskById(String taskId) {
        if (taskId == null) {
            return Optional.empty();
        }
        return tasks.stream()
                    .filter(task -> task.getId().equals(taskId))
                    .findFirst();
    }

    public boolean addTask(Task task) {
        if (task == null) { // Defensive check for null task
            return false;
        }
        return tasks.add(task); // Set.add handles duplicates based on Task's equals/hashCode
    }

    public boolean removeTask(String taskId) {
        if (taskId == null) { // Defensive check for null taskId
            return false;
        }
        Optional<Task> taskToRemove = getTaskById(taskId);
        if (taskToRemove.isPresent()) {
            return tasks.remove(taskToRemove.get());
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectId, project.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId);
    }
}

public class ProjectManagementSystem {
    // Changed to Map for O(1) project lookups by projectId
    private Map<String, Project> projects;

    public ProjectManagementSystem() {
        this.projects = new HashMap<>();
    }

    public boolean addProject(Project project) {
        if (project == null || projects.containsKey(project.getProjectId())) { // Defensive check and check for existing ID
            return false;
        }
        projects.put(project.getProjectId(), project);
        return true;
    }

    public boolean removeProject(String projectId) {
        if (projectId == null) { // Defensive check for null projectId
            return false;
        }
        return projects.remove(projectId) != null; // remove returns the value if present, null otherwise
    }

    public boolean addTaskToProject(String projectId, Task task) {
        if (projectId == null || task == null) { // Defensive check for null inputs
            return false;
        }
        Project project = projects.get(projectId); // O(1) lookup
        if (project != null) {
            return project.addTask(task);
        }
        return false;
    }

    public boolean updateTaskStatus(String projectId, String taskId, String newStatus) {
        if (projectId == null || taskId == null || newStatus == null) { // Defensive check for null inputs
            return false;
        }
        Project project = projects.get(projectId); // O(1) lookup
        if (project != null) {
            Optional<Task> task = project.getTaskById(taskId);
            if (task.isPresent()) {
                task.get().setStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    public Set<Task> getProjectTasks(String projectId) {
        if (projectId == null) { // Defensive check for null projectId
            return Collections.emptySet(); // Return empty set for invalid ID
        }
        Project project = projects.get(projectId); // O(1) lookup
        if (project != null) {
            // Return an unmodifiable view to maintain encapsulation
            return project.getTasks(); // project.getTasks() already returns unmodifiable
        }
        return Collections.emptySet(); // Return empty set if project not found
    }
}