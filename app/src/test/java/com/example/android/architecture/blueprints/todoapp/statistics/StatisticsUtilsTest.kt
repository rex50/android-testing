package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    // If there is no completed task and one active task,
    // then there are 100% percent active tasks and 0% completed tasks.
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred() {
        val tasks = listOf(
            Task("Title", "desc", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    // If there is 2 completed and 3 active tasks,
    // then there are 40% completed tasks and 60% active tasks.
    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        val tasks = listOf(
            Task("Title", "desc", isCompleted = true),
            Task("Title", "desc", isCompleted = true),
            Task("Title", "desc", isCompleted = false),
            Task("Title", "desc", isCompleted = false),
            Task("Title", "desc", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)
        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        val tasks = emptyList<Task>()
        val result = getActiveAndCompletedStats(tasks)
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        val tasks = null
        val result = getActiveAndCompletedStats(tasks)
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

}