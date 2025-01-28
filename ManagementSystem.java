package employeeManagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Employee {
	int id;
	String name;
	String dept;

	
	public Employee(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}



	@Override
	public String toString() {
    return "ID: " + id + ", Name: " + name + ", Department: " + dept;
	}
}


class Tasks {
	int taskID;
	String descr;
	int prio;
	String status;
	
	public Tasks(int taskID, String descr, int prio, String status) {
		this.taskID = taskID;
		this.descr = descr;
		this.prio = prio;
		this.status = status;
		
	}
	
	@Override
	public String toString() {
        return "TaskID: " + taskID + ", Description: " + descr + ", Priority: " + prio + ", Status: " + status;
    }

}


class EmployeeTaskManagement {
	private static HashMap<Integer, Employee> emp = new HashMap<>();
	private static HashMap<Integer, List<Tasks>> tasksByEmployee = new HashMap<>();
	private static PriorityQueue<Tasks> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(task -> task.prio));
	private static LinkedList<Tasks> pendingTasks = new LinkedList<>();
	
	// method to add employee
	
	  public static void addEmployee(int id, String name, String department) {
	        emp.put(id, new Employee(id, name, department));
	        getTasksByEmployee().putIfAbsent(id, new ArrayList<>());
	  }

	  
	  public static void assignTask(int employeeId, int taskId, String description, int priority) {
	        if (!emp.containsKey(employeeId)) {
	            System.out.println("Employee not found!");
	            return;
	        }
	        Tasks task = new Tasks(taskId, description, priority, "Pending");
	        getTasksByEmployee().get(employeeId).add(task);
	        priorityQueue.add(task);
	        pendingTasks.add(task);
	    }
	  
	  public static void getTasksByPriority() {
	        System.out.println("Tasks by Priority:");
	        PriorityQueue<Tasks> tempQueue = new PriorityQueue<>(priorityQueue);
	        while (!tempQueue.isEmpty()) {
	            System.out.println(tempQueue.poll());
	        }
	    }
	  
	  public static void getTasksByEmployeeName(String name) {
	        System.out.println("Tasks for Employee: " + name);
	        for (Map.Entry<Integer, Employee> entry : emp.entrySet()) {
	            if (entry.getValue().name.equalsIgnoreCase(name)) {
	                List<Tasks> tasks = getTasksByEmployee().get(entry.getKey());
	                tasks.forEach(System.out::println);
	                return;
	            }
	        }
	        System.out.println("Employee not found!");
	    }
	  
	  
	  public static void getTasksByDepartment(String department) {
	        System.out.println("Tasks for Department: " + department);
	        for (Map.Entry<Integer, Employee> entry : emp.entrySet()) {
	            if (entry.getValue().dept.equalsIgnoreCase(department)) {
	                List<Tasks> tasks = getTasksByEmployee().get(entry.getKey());
	                tasks.forEach(System.out::println);
	            }
	        }
	    }
	  
	  public static void removeCompletedTasks() {
	        System.out.println("Removing Completed Tasks...");
	        for (List<Tasks> taskList : getTasksByEmployee().values()) {
	            taskList.removeIf(task -> task.status.equalsIgnoreCase("Completed"));
	        }
	        pendingTasks.removeIf(task -> task.status.equalsIgnoreCase("Completed"));
	        priorityQueue.removeIf(task -> task.status.equalsIgnoreCase("Completed"));
	    }

	    // Method to track pending tasks
	    public static void trackPendingTasks() {
	        System.out.println("Pending Tasks:");
	        pendingTasks.forEach(System.out::println);
	    }


		public static HashMap<Integer, List<Tasks>> getTasksByEmployee() {
			return tasksByEmployee;
		}


		public static void setTasksByEmployee(HashMap<Integer, List<Tasks>> tasksByEmployee) {
			EmployeeTaskManagement.tasksByEmployee = tasksByEmployee;
		}
	    
	    
}

public class ManagementSystem{


public static void main(String[] args) {
        // Adding employees
        
	Scanner scanner = new Scanner(System.in);
    int choice;

    while (true) {
        System.out.println("\nEmployee Task Management System");
        System.out.println("1. Add Employee");
        System.out.println("2. Assign Task");
        System.out.println("3. Retrieve Tasks by Priority");
        System.out.println("4. Retrieve Tasks by Employee Name");
        System.out.println("5. Retrieve Tasks by Department");
        System.out.println("6. Mark Task as Completed");
        System.out.println("7. Remove Completed Tasks");
        System.out.println("8. Track Pending Tasks");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Employee ID: ");
                int empId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter Employee Name: ");
                String empName = scanner.nextLine();
                System.out.print("Enter Employee Department: ");
                String empDept = scanner.nextLine();
                EmployeeTaskManagement.addEmployee(empId, empName, empDept);
                System.out.println("Employee added successfully.");
                break;

            case 2:
                System.out.print("Enter Employee ID: ");
                int taskEmpId = scanner.nextInt();
                System.out.print("Enter Task ID: ");
                int taskId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter Task Description: ");
                String taskDesc = scanner.nextLine();
                System.out.print("Enter Task Priority: ");
                int taskPriority = scanner.nextInt();
                EmployeeTaskManagement.assignTask(taskEmpId, taskId, taskDesc, taskPriority);
                System.out.println("Task assigned successfully.");
                break;

            case 3:
                System.out.println("Retrieving Tasks by Priority:");
                EmployeeTaskManagement.getTasksByPriority();
                break;

            case 4:
                System.out.print("Enter Employee Name: ");
                String searchName = scanner.nextLine();
                EmployeeTaskManagement.getTasksByEmployeeName(searchName);
                break;

            case 5:
                System.out.print("Enter Department Name: ");
                String searchDept = scanner.nextLine();
                EmployeeTaskManagement.getTasksByDepartment(searchDept);
                break;

            case 6:
                System.out.print("Enter Employee ID: ");
                int markEmpId = scanner.nextInt();
                System.out.print("Enter Task ID to Mark as Completed: ");
                int markTaskId = scanner.nextInt();
                if (EmployeeTaskManagement.getTasksByEmployee().containsKey(markEmpId)) {
                    boolean taskFound = false;
                    for (Tasks task : EmployeeTaskManagement.getTasksByEmployee().get(markEmpId)) {
                        if (task.taskID == markTaskId) {
                            task.status = "Completed";
                            taskFound = true;
                            System.out.println("Task marked as Completed.");
                            break;
                        }
                    }
                    if (!taskFound) {
                        System.out.println("Task not found for the given Employee ID.");
                    }
                } else {
                    System.out.println("Employee ID not found.");
                }
                break;

            case 7:
                EmployeeTaskManagement.removeCompletedTasks();
                System.out.println("Completed tasks removed.");
                break;

            case 8:
                System.out.println("Tracking Pending Tasks:");
                EmployeeTaskManagement.trackPendingTasks();
                break;

            case 9:
                System.out.println("Exiting the system. Goodbye!");
                scanner.close();
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    }
}
    
