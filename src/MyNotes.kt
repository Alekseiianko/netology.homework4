class MyNotes {

    private val noteMap = hashMapOf<Int, Notes>()
    private val noteCommentMap = hashMapOf<Int, Comment>()
    private var number = 1


    fun addNote(note: Notes): Int {
        noteMap.put(note.id, note)
        return note.id
    }

    fun deleteNote(id: Int): Boolean = noteMap.remove(id) != null

    fun editNote(id: Int, title: String, text: String): Boolean {
        val newNote = noteMap.remove(id)
        return if (newNote != null) {
            addNote(newNote.copy(title = title, text = text))
            true
        } else {
            false
        }
    }

    fun getNotes(): Map<Int, Notes> = noteMap.toMap()


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

    fun deleteComment(noteId: Int, commentId: Int): Boolean {
        val comment = noteCommentMap[noteId] ?: return false
        return if (commentId == comment.id) {
            noteCommentMap.remove(noteId, comment)
        } else {
            false
        }
    }

    fun editComment(noteId: Int, commentId: Int, text: String) {
        deleteComment(noteId, commentId)
        addComment(noteId, text)
    }

    fun getComments(): Map<Int, Comment> = noteCommentMap.toMap()

}
