package com.mynotes.dao;

import com.mynotes.model.Note;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class NoteDAOImpl implements  NoteDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createNote(Note note) {
        note.setCreateDate(new Date());
        entityManager.persist(note);
    }

    @Override
    public void updateNote(Note note) {
        note.setCreateDate(new Date());
        entityManager.merge(note);
    }

    @Override
    public void deleteNote(long id) {
        Note n = entityManager.find(Note.class,id);
        entityManager.remove(n);
    }

    @Override
    public List<Note> getNotesByPaging(int page,int offset, String filter, String sort) {
        String query = "";

        if (filter.equals("all")) query = "from Note n";
        if (filter.equals("done")) query = "from Note n WHERE n.isDone=1";
        if (filter.equals("undone")) query = "from Note n WHERE n.isDone=0";

        if (sort.equals("asc")) query += " ORDER BY n.createDate ASC";
        if (sort.equals("desc")) query += " ORDER BY n.createDate DESC";

        return entityManager
                .createQuery(query)
                .setFirstResult(page*offset-offset)
                .setMaxResults(offset)
                .getResultList();
    }

    @Override
    public int getSize(String filter) {
        String query = "select count (*) from Note n";

        if (filter.equals("done")) query += " WHERE n.isDone=1";
        if (filter.equals("undone")) query += " WHERE n.isDone=0";

        return Integer.parseInt(
            entityManager
                .createQuery(query)
                .getSingleResult()
                .toString()
        );
    }

    @Override
    public void setIsDone(int id, int done) {
        String query = "update Note n set n.isDone =" + done + " where n.id=" + id;

        entityManager
            .createQuery(query)
            .executeUpdate();
    }
}
