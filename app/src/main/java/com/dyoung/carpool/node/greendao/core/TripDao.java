package com.dyoung.carpool.node.greendao.core;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.dyoung.carpool.node.greendao.model.Trip;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TRIP".
*/
public class TripDao extends AbstractDao<Trip, Long> {

    public static final String TABLENAME = "TRIP";

    /**
     * Properties of entity Trip.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property SetOut = new Property(1, String.class, "setOut", false, "SET_OUT");
        public final static Property ArriveCity = new Property(2, String.class, "arriveCity", false, "ARRIVE_CITY");
    }

    private DaoSession daoSession;


    public TripDao(DaoConfig config) {
        super(config);
    }
    
    public TripDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TRIP\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"SET_OUT\" TEXT NOT NULL ," + // 1: setOut
                "\"ARRIVE_CITY\" TEXT NOT NULL );"); // 2: arriveCity
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TRIP\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Trip entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getSetOut());
        stmt.bindString(3, entity.getArriveCity());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Trip entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getSetOut());
        stmt.bindString(3, entity.getArriveCity());
    }

    @Override
    protected final void attachEntity(Trip entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Trip readEntity(Cursor cursor, int offset) {
        Trip entity = new Trip( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // setOut
            cursor.getString(offset + 2) // arriveCity
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Trip entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSetOut(cursor.getString(offset + 1));
        entity.setArriveCity(cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Trip entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Trip entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Trip entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
