fun main() {
    // Req 1
    // list of students
    val immStudentNames = listOf("Emad", "Omar", "Arwa", "Mohammed", "Yasmeen")
    var mStudentNames = mutableListOf("Emad", "Omar", "Arwa", "Mohammed", "Yasmeen")
    // each student has its own score
    val immStudentScore = mapOf(
        "Emad" to 89,
        "Omar" to 92,
        "Arwa" to 56,
        "Mohammed" to 76,
        "Yasmeen" to 64
    )
    var mStudentScore = mutableMapOf(
        "Emad" to 89,
        "Omar" to 92,
        "Arwa" to 56,
        "Mohammed" to 76,
        "Yasmeen" to 64
    )
    // graduated students
    val immGradStudents = setOf("Emad", "Arwa")
    var mGradStudents = mutableSetOf("Emad", "Arwa")

    println("Student Names: $immStudentNames")
    println("Student Scores: $immStudentScore")
    println("Grad Students: $immGradStudents")

    // Req 2
    println("▶ Student names")
    immStudentNames.forEach {
        print("$it\t")
    }
    // search about score by student's name
    print("\nEnter student name to get score: ")
    val studentName = readln().trim()
    immStudentScore.forEach {
        if (studentName == it.key)
            println("${studentName}'s score is ${it.value}")

    }
//    filter students that not grads
    // Req 3
    mStudentNames = mStudentNames.filter { student ->
        student !in immGradStudents.toList()
    }.toMutableList()
    println("Students filtered:")
    mStudentNames.forEach {
        print("$it\t")
    }

    // total score
    // Req 4
    println("\n▶ Total score: ")
    val totalScore = immStudentScore.values.reduce { acc, score -> acc + score }
    println("Total score is $totalScore")

    println("\n▶ Formatted String :")
    val formattedString = immStudentScore.entries.fold("") { acc, entry ->
        if (acc.isEmpty()) "${entry.key}: ${entry.value}"
        else "$acc | ${entry.key}: ${entry.value}"
    }
    println(formattedString)
//
//
    // Req 5
    generateStudentReport(immStudentScore)

}

// Req 5
// report for passed students
fun generateStudentReport(students: Map<String, Int>) {
    if (students.isEmpty()) {
        println("No student data available.")
        return
    }

    println("\n▶ Student Grade Report (Passed Students):")
    students
        .filter { it.value >= 60 }
        .map { "${it.key}: ${it.value}" }
        .forEach { println(it) }
}
