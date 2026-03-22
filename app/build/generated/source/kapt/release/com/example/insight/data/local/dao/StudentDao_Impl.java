package com.example.insight.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.insight.data.local.entities.StudentEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StudentDao_Impl implements StudentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StudentEntity> __insertionAdapterOfStudentEntity;

  private final EntityDeletionOrUpdateAdapter<StudentEntity> __deletionAdapterOfStudentEntity;

  private final EntityDeletionOrUpdateAdapter<StudentEntity> __updateAdapterOfStudentEntity;

  public StudentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStudentEntity = new EntityInsertionAdapter<StudentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `student_table` (`studentId`,`name`,`gender`,`age`,`className`,`latestScore`,`createdAt`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudentEntity entity) {
        if (entity.getStudentId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getStudentId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getGender());
        statement.bindLong(4, entity.getAge());
        if (entity.getClassName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getClassName());
        }
        statement.bindDouble(6, entity.getLatestScore());
        statement.bindLong(7, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfStudentEntity = new EntityDeletionOrUpdateAdapter<StudentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `student_table` WHERE `studentId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudentEntity entity) {
        if (entity.getStudentId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getStudentId());
        }
      }
    };
    this.__updateAdapterOfStudentEntity = new EntityDeletionOrUpdateAdapter<StudentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `student_table` SET `studentId` = ?,`name` = ?,`gender` = ?,`age` = ?,`className` = ?,`latestScore` = ?,`createdAt` = ? WHERE `studentId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudentEntity entity) {
        if (entity.getStudentId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getStudentId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getGender());
        statement.bindLong(4, entity.getAge());
        if (entity.getClassName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getClassName());
        }
        statement.bindDouble(6, entity.getLatestScore());
        statement.bindLong(7, entity.getCreatedAt());
        if (entity.getStudentId() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getStudentId());
        }
      }
    };
  }

  @Override
  public Object insertStudent(final StudentEntity student, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStudentEntity.insert(student);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertStudents(final List<StudentEntity> students,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStudentEntity.insert(students);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteStudent(final StudentEntity student, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfStudentEntity.handle(student);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateStudent(final StudentEntity student, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfStudentEntity.handle(student);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Flow<List<StudentEntity>> getAllStudentsFlow() {
    final String _sql = "SELECT * FROM student_table ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"student_table"}, new Callable<List<StudentEntity>>() {
      @Override
      @NonNull
      public List<StudentEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfLatestScore = CursorUtil.getColumnIndexOrThrow(_cursor, "latestScore");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<StudentEntity> _result = new ArrayList<StudentEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StudentEntity _item;
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpGender;
            _tmpGender = _cursor.getInt(_cursorIndexOfGender);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final float _tmpLatestScore;
            _tmpLatestScore = _cursor.getFloat(_cursorIndexOfLatestScore);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new StudentEntity(_tmpStudentId,_tmpName,_tmpGender,_tmpAge,_tmpClassName,_tmpLatestScore,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getStudentById(final String id, final Continuation<? super StudentEntity> arg1) {
    final String _sql = "SELECT * FROM student_table WHERE studentId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<StudentEntity>() {
      @Override
      @Nullable
      public StudentEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfLatestScore = CursorUtil.getColumnIndexOrThrow(_cursor, "latestScore");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final StudentEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpGender;
            _tmpGender = _cursor.getInt(_cursorIndexOfGender);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final float _tmpLatestScore;
            _tmpLatestScore = _cursor.getFloat(_cursorIndexOfLatestScore);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new StudentEntity(_tmpStudentId,_tmpName,_tmpGender,_tmpAge,_tmpClassName,_tmpLatestScore,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  @Override
  public Flow<List<StudentEntity>> searchStudentsFlow(final String query) {
    final String _sql = "SELECT * FROM student_table WHERE name LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"student_table"}, new Callable<List<StudentEntity>>() {
      @Override
      @NonNull
      public List<StudentEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfLatestScore = CursorUtil.getColumnIndexOrThrow(_cursor, "latestScore");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<StudentEntity> _result = new ArrayList<StudentEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StudentEntity _item;
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpGender;
            _tmpGender = _cursor.getInt(_cursorIndexOfGender);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final float _tmpLatestScore;
            _tmpLatestScore = _cursor.getFloat(_cursorIndexOfLatestScore);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new StudentEntity(_tmpStudentId,_tmpName,_tmpGender,_tmpAge,_tmpClassName,_tmpLatestScore,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
