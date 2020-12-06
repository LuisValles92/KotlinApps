package es.attomic.meloappuntoeoi.Interfaces

interface TaskListener {
  fun deleteTask(idTask: String)
  fun completeTask(idTask: String, isDone: Boolean)
}