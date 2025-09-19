class TaskManager {
    class TaskInfo {
        int userId;
        int taskId;
        int priority; 
        public TaskInfo(int userId, int taskId, int priority) {
            this.userId = userId; 
            this.taskId = taskId; 
            this.priority = priority;
        }
    }

    Map<Integer, TaskInfo> taskMap = new HashMap<>();
    PriorityQueue<TaskInfo> taskQueue = new PriorityQueue<>(
        (a, b) -> {
            if (a.priority == b.priority)  {
                return b.taskId  - a.taskId;
            }
            return b.priority - a.priority;
        }
    );

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) { 
            TaskInfo tsk = new TaskInfo(task.get(0), task.get(1), task.get(2));
            taskQueue.add(tsk);
            taskMap.put(tsk.taskId, tsk);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        TaskInfo tsk = new TaskInfo(userId, taskId, priority);
        taskQueue.add(tsk);
        taskMap.put(taskId, tsk);
    }

    public void edit(int taskId, int newPriority) {
        TaskInfo curr = taskMap.get(taskId);
        TaskInfo newTask = new TaskInfo(curr.userId, taskId, newPriority);
        taskQueue.add(newTask);
        taskMap.put(taskId, newTask);
        
    }
    
    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        // System.out.println("==========");
        // for (Integer i : taskMap.keySet()) { 
        //     TaskInfo task = taskMap.get(i);
        //     System.out.println(task.userId + " " + task.taskId + " " + task.priority);
        // }

        while (!taskQueue.isEmpty()) { 
            TaskInfo top = taskQueue.poll();
            TaskInfo current = taskMap.get(top.taskId);
            // System.out.println("Current top value: " + top.userId + " " + top.taskId + " " + top.priority);
            // System.out.println("Current value: " + current.userId + " " + current.taskId + " " + current.priority);
            
            if (current == null) continue;
            if (top.priority != current.priority) continue;
            taskMap.remove(top.taskId);
            return current.userId;
        }
        return -1;
    }
}
