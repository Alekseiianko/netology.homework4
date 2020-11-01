class MyNotes {

    private var noteMap = hashMapOf<Int, Notes>()
    private var noteCommentMap = hashMapOf<Int, Comment>()
    private var number = 1


    fun addNote(note: Notes): Int {
        noteMap.put(note.id, note)
        return note.id
    }

    fun deleteNote(id: Int): Int {
        noteMap.remove(id)
        return 1
    }

    fun editNote(id: Int, title: String, text: String): Int {
        val newNote = noteMap.get(id)
        deleteNote(id)
        if (newNote != null) {
            newNote.title = title
            newNote.text = text
            addNote(newNote)
        } else {
            println("Not correct")
        }
        return 1
    }

    fun getNotes() {
        noteMap.forEach {
            println(it)
        }
    }

    fun getNotesById(id: Int) {
        println(noteMap.get(id))
    }

    fun addComment(id: Int, text: String) {
        val note = noteMap.get(id)
        val comment = Comment(number++, text)
        if (note != null) {
            noteCommentMap.put(note.id, comment)
            println("$note ${noteCommentMap.get(id)}")
        } else {
            print("error")
        }
    }

    fun deleteComment(noteId: Int, commentId: Int) {
        val note = noteMap.get(noteId)
        val comment = noteCommentMap.getValue(noteId)
        if (noteCommentMap.containsKey(noteId)) {
            if (commentId.equals(comment.id)) {
                noteCommentMap.remove(noteId, comment)
                println("$note ${noteCommentMap.get(noteId)}")
            }
        } else {
            println("Error")
        }
    }

    fun editComment(noteId: Int, commentId: Int, text: String) {
        deleteComment(noteId, commentId)
        addComment(noteId, text)
    }

    fun getComments() {
        noteCommentMap.forEach() {
            println(it.value)
        }
    }
}
