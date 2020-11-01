fun main() {

    val myNotes = MyNotes()

    val firstNote = Notes(1,"Hello", "its me", true)
    val secondNote = Notes (2,"Good evening", "im tired, rly", true)
    val thirdNote = Notes (3,"Im so happy", "its false", true)

    myNotes.addNote(firstNote)
    myNotes.addNote(secondNote)
    myNotes.addNote(thirdNote)
    println(myNotes.getNotes())

    println("_______________________")

    myNotes.editNote(1,"bye", "its you")
    println(myNotes.getNotes())

    println("_______________________")

    myNotes.deleteNote(1)
    println(myNotes.getNotes())

    println("_______________________")

    myNotes.getNotesById(2)

    println("_______________________")

    myNotes.addComment(2,"wow")
    myNotes.addComment(2,"nice")
    myNotes.addComment(2,"bye")
    myNotes.addComment(3, "nice news")
    myNotes.addComment(3, "hello")

    println("_______________________")

    myNotes.deleteComment(2,2)

    println("_______________________")

    myNotes.editComment(3,2,"why always me")

    println("_______________________")

    myNotes.getComments()

}