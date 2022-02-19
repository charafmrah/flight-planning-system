package com.example.aviationsystem.viewmodel

import androidx.lifecycle.*
import com.example.aviationsystem.model.daos.RouteDao
import com.example.aviationsystem.model.relations.SourceAirportsWithRoutes
import kotlinx.coroutines.launch
import kotlin.math.roundToLong

/**
 * View Model to keep a reference to the GPA Calculator repository and an up-to-date list of all courses.
 *
 */
class RouteViewModel(private val routeDao: RouteDao) : ViewModel() {

    // Cache all courses from the database using LiveData
    val allCourses: LiveData<List<SourceAirportsWithRoutes>> = routeDao.getSourceWithRoute(routeDao.get).asLiveData()

    fun calculateGpa(): Double {
        val gpa = 0.0
        var creditTimesGrade = 0.0
        var credits = 0

        allCourses.value?.forEach {
            credits += it.courseCredit
        }

        allCourses.value?.forEach {
            creditTimesGrade += it.courseCredit * letterGradeToNumber(it.courseGrade)
        }

        return String.format("%.2f", creditTimesGrade / credits).toDouble()
    }

    // Updates an existing course in the database
    fun updateCourse(
        courseId: Int,
        courseName: String,
        courseCredit: String,
        courseGrade: String
    ) {
        val updatedCourse = getUpdatedCourseEntry(courseId, courseName, courseCredit, courseGrade)
        updateCourse(updatedCourse)
    }

    // Launching a new coroutine to update a course in a non-blocking way
    private fun updateCourse(course: Course) {
        viewModelScope.launch {
            routeDao.update(course)
        }
    }

    /*
    * Called to update an existing entry in the database.
    * Returns an  instance of the [Course] entity class with the course info updated by the user
     */
    private fun getUpdatedCourseEntry(
        courseId: Int,
        courseName: String,
        courseCredit: String,
        courseGrade: String
    ): Course {
        return Course(
            id = courseId,
            courseName = courseName,
            courseCredit = courseCredit.toInt(),
            courseGrade = courseGrade
        )
    }

    // Inserts the new Course into database
    fun addNewCourse(courseName: String, courseCredit: String, courseGrade: String) {
        val newCourse = getNewCourseEntry(courseName, courseCredit, courseGrade)
        insertCourse(newCourse)
    }

    /*
    * Called to updated an existing entry in the database.
    * Returns an instance of the [Course] entity class with the course info updadtedd by the user
     */
    private fun getNewCourseEntry(
        courseName: String, courseCredit: String, courseGrade: String
    ): Course {
        return Course(
            courseName = courseName,
            courseCredit = courseCredit.toInt(),
            courseGrade = courseGrade
        )
    }

    // Launching a new coroutine to insert a course in a non-blocking way
    private fun insertCourse(course: Course) {
        viewModelScope.launch {
            routeDao.insert(course)
        }
    }

    // Launching a new coroutine to delete a course in a non-blocking way
    fun deleteCourse(course: Course) {
        viewModelScope.launch {
            routeDao.delete(course)
        }
    }

    // Retrieve a course from the repository
    fun retrieveCourse(id: Int): LiveData<Course> {
        return routeDao.getCourse(id).asLiveData()
    }

    // Returns true if the EditTexts are not empty
    fun isEntryValid(
        courseName: String, courseCredit: String, courseGrade: String
    ): Boolean {
        return !(courseName.isBlank() || courseCredit.isBlank() || courseGrade.isBlank())
    }

}

// Factory class to instantiate the [ViewModel] isntance.
class CalculatorViewModelFactory(private val courseDao: CourseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalculatorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CalculatorViewModel(courseDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}