package com.example.insight.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.insight.data.local.entities.KnowledgeClosureEntity;
import com.example.insight.data.local.entities.KnowledgeEdgeEntity;
import com.example.insight.data.local.entities.KnowledgeNodeEntity;
import com.example.insight.data.local.entities.StudentMasteryEntity;
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
public final class KnowledgeDao_Impl implements KnowledgeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<KnowledgeNodeEntity> __insertionAdapterOfKnowledgeNodeEntity;

  private final EntityInsertionAdapter<KnowledgeEdgeEntity> __insertionAdapterOfKnowledgeEdgeEntity;

  private final EntityInsertionAdapter<KnowledgeClosureEntity> __insertionAdapterOfKnowledgeClosureEntity;

  private final EntityInsertionAdapter<StudentMasteryEntity> __insertionAdapterOfStudentMasteryEntity;

  public KnowledgeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKnowledgeNodeEntity = new EntityInsertionAdapter<KnowledgeNodeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `knowledge_nodes` (`nodeId`,`title`,`category`,`importanceLevel`,`canvasX`,`canvasY`,`description`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final KnowledgeNodeEntity entity) {
        if (entity.getNodeId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getNodeId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        statement.bindLong(3, entity.getCategory());
        statement.bindLong(4, entity.getImportanceLevel());
        statement.bindDouble(5, entity.getCanvasX());
        statement.bindDouble(6, entity.getCanvasY());
        if (entity.getDescription() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDescription());
        }
      }
    };
    this.__insertionAdapterOfKnowledgeEdgeEntity = new EntityInsertionAdapter<KnowledgeEdgeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `knowledge_edges` (`edgeId`,`sourceNodeId`,`targetNodeId`,`relationType`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final KnowledgeEdgeEntity entity) {
        statement.bindLong(1, entity.getEdgeId());
        if (entity.getSourceNodeId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getSourceNodeId());
        }
        if (entity.getTargetNodeId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTargetNodeId());
        }
        if (entity.getRelationType() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getRelationType());
        }
      }
    };
    this.__insertionAdapterOfKnowledgeClosureEntity = new EntityInsertionAdapter<KnowledgeClosureEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `knowledge_closure_table` (`ancestorId`,`descendantId`,`depth`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final KnowledgeClosureEntity entity) {
        if (entity.getAncestorId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getAncestorId());
        }
        if (entity.getDescendantId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDescendantId());
        }
        statement.bindLong(3, entity.getDepth());
      }
    };
    this.__insertionAdapterOfStudentMasteryEntity = new EntityInsertionAdapter<StudentMasteryEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `student_mastery` (`studentId`,`nodeId`,`masteryScore`,`lastUpdateTime`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudentMasteryEntity entity) {
        if (entity.getStudentId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getStudentId());
        }
        if (entity.getNodeId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNodeId());
        }
        statement.bindDouble(3, entity.getMasteryScore());
        statement.bindLong(4, entity.getLastUpdateTime());
      }
    };
  }

  @Override
  public Object insertNodes(final List<KnowledgeNodeEntity> nodes,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfKnowledgeNodeEntity.insert(nodes);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertEdges(final List<KnowledgeEdgeEntity> edges,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfKnowledgeEdgeEntity.insert(edges);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertClosure(final List<KnowledgeClosureEntity> closures,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfKnowledgeClosureEntity.insert(closures);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateMastery(final StudentMasteryEntity mastery,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStudentMasteryEntity.insert(mastery);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateMasteryWithRules(final String studentId, final String nodeId,
      final boolean isCorrect, final Continuation<? super Unit> arg3) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> KnowledgeDao.DefaultImpls.updateMasteryWithRules(KnowledgeDao_Impl.this, studentId, nodeId, isCorrect, __cont), arg3);
  }

  @Override
  public Flow<List<KnowledgeNodeEntity>> getAllNodes() {
    final String _sql = "SELECT * FROM knowledge_nodes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"knowledge_nodes"}, new Callable<List<KnowledgeNodeEntity>>() {
      @Override
      @NonNull
      public List<KnowledgeNodeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfImportanceLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "importanceLevel");
          final int _cursorIndexOfCanvasX = CursorUtil.getColumnIndexOrThrow(_cursor, "canvasX");
          final int _cursorIndexOfCanvasY = CursorUtil.getColumnIndexOrThrow(_cursor, "canvasY");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final List<KnowledgeNodeEntity> _result = new ArrayList<KnowledgeNodeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KnowledgeNodeEntity _item;
            final String _tmpNodeId;
            if (_cursor.isNull(_cursorIndexOfNodeId)) {
              _tmpNodeId = null;
            } else {
              _tmpNodeId = _cursor.getString(_cursorIndexOfNodeId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final int _tmpCategory;
            _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
            final int _tmpImportanceLevel;
            _tmpImportanceLevel = _cursor.getInt(_cursorIndexOfImportanceLevel);
            final float _tmpCanvasX;
            _tmpCanvasX = _cursor.getFloat(_cursorIndexOfCanvasX);
            final float _tmpCanvasY;
            _tmpCanvasY = _cursor.getFloat(_cursorIndexOfCanvasY);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _item = new KnowledgeNodeEntity(_tmpNodeId,_tmpTitle,_tmpCategory,_tmpImportanceLevel,_tmpCanvasX,_tmpCanvasY,_tmpDescription);
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
  public Flow<List<KnowledgeEdgeEntity>> getAllEdges() {
    final String _sql = "SELECT * FROM knowledge_edges";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"knowledge_edges"}, new Callable<List<KnowledgeEdgeEntity>>() {
      @Override
      @NonNull
      public List<KnowledgeEdgeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEdgeId = CursorUtil.getColumnIndexOrThrow(_cursor, "edgeId");
          final int _cursorIndexOfSourceNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "sourceNodeId");
          final int _cursorIndexOfTargetNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "targetNodeId");
          final int _cursorIndexOfRelationType = CursorUtil.getColumnIndexOrThrow(_cursor, "relationType");
          final List<KnowledgeEdgeEntity> _result = new ArrayList<KnowledgeEdgeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KnowledgeEdgeEntity _item;
            final long _tmpEdgeId;
            _tmpEdgeId = _cursor.getLong(_cursorIndexOfEdgeId);
            final String _tmpSourceNodeId;
            if (_cursor.isNull(_cursorIndexOfSourceNodeId)) {
              _tmpSourceNodeId = null;
            } else {
              _tmpSourceNodeId = _cursor.getString(_cursorIndexOfSourceNodeId);
            }
            final String _tmpTargetNodeId;
            if (_cursor.isNull(_cursorIndexOfTargetNodeId)) {
              _tmpTargetNodeId = null;
            } else {
              _tmpTargetNodeId = _cursor.getString(_cursorIndexOfTargetNodeId);
            }
            final String _tmpRelationType;
            if (_cursor.isNull(_cursorIndexOfRelationType)) {
              _tmpRelationType = null;
            } else {
              _tmpRelationType = _cursor.getString(_cursorIndexOfRelationType);
            }
            _item = new KnowledgeEdgeEntity(_tmpEdgeId,_tmpSourceNodeId,_tmpTargetNodeId,_tmpRelationType);
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
  public Object getPrerequisites(final String nodeId,
      final Continuation<? super List<KnowledgeNodeEntity>> arg1) {
    final String _sql = "\n"
            + "        SELECT n.* FROM knowledge_nodes n\n"
            + "        JOIN knowledge_edges e ON n.nodeId = e.sourceNodeId\n"
            + "        WHERE e.targetNodeId = ? AND e.relationType = 'PREREQUISITE'\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nodeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nodeId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<KnowledgeNodeEntity>>() {
      @Override
      @NonNull
      public List<KnowledgeNodeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfImportanceLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "importanceLevel");
          final int _cursorIndexOfCanvasX = CursorUtil.getColumnIndexOrThrow(_cursor, "canvasX");
          final int _cursorIndexOfCanvasY = CursorUtil.getColumnIndexOrThrow(_cursor, "canvasY");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final List<KnowledgeNodeEntity> _result = new ArrayList<KnowledgeNodeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KnowledgeNodeEntity _item;
            final String _tmpNodeId;
            if (_cursor.isNull(_cursorIndexOfNodeId)) {
              _tmpNodeId = null;
            } else {
              _tmpNodeId = _cursor.getString(_cursorIndexOfNodeId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final int _tmpCategory;
            _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
            final int _tmpImportanceLevel;
            _tmpImportanceLevel = _cursor.getInt(_cursorIndexOfImportanceLevel);
            final float _tmpCanvasX;
            _tmpCanvasX = _cursor.getFloat(_cursorIndexOfCanvasX);
            final float _tmpCanvasY;
            _tmpCanvasY = _cursor.getFloat(_cursorIndexOfCanvasY);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _item = new KnowledgeNodeEntity(_tmpNodeId,_tmpTitle,_tmpCategory,_tmpImportanceLevel,_tmpCanvasX,_tmpCanvasY,_tmpDescription);
            _result.add(_item);
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
  public Flow<List<KnowledgeNodeEntity>> getAncestors(final String nodeId) {
    final String _sql = "\n"
            + "        SELECT n.* FROM knowledge_nodes n\n"
            + "        JOIN knowledge_closure_table c ON n.nodeId = c.ancestorId\n"
            + "        WHERE c.descendantId = ? AND c.depth > 0\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nodeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nodeId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"knowledge_nodes",
        "knowledge_closure_table"}, new Callable<List<KnowledgeNodeEntity>>() {
      @Override
      @NonNull
      public List<KnowledgeNodeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfImportanceLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "importanceLevel");
          final int _cursorIndexOfCanvasX = CursorUtil.getColumnIndexOrThrow(_cursor, "canvasX");
          final int _cursorIndexOfCanvasY = CursorUtil.getColumnIndexOrThrow(_cursor, "canvasY");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final List<KnowledgeNodeEntity> _result = new ArrayList<KnowledgeNodeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KnowledgeNodeEntity _item;
            final String _tmpNodeId;
            if (_cursor.isNull(_cursorIndexOfNodeId)) {
              _tmpNodeId = null;
            } else {
              _tmpNodeId = _cursor.getString(_cursorIndexOfNodeId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final int _tmpCategory;
            _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
            final int _tmpImportanceLevel;
            _tmpImportanceLevel = _cursor.getInt(_cursorIndexOfImportanceLevel);
            final float _tmpCanvasX;
            _tmpCanvasX = _cursor.getFloat(_cursorIndexOfCanvasX);
            final float _tmpCanvasY;
            _tmpCanvasY = _cursor.getFloat(_cursorIndexOfCanvasY);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _item = new KnowledgeNodeEntity(_tmpNodeId,_tmpTitle,_tmpCategory,_tmpImportanceLevel,_tmpCanvasX,_tmpCanvasY,_tmpDescription);
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
  public Flow<List<StudentMasteryEntity>> getStudentMastery(final String studentId) {
    final String _sql = "SELECT * FROM student_mastery WHERE studentId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"student_mastery"}, new Callable<List<StudentMasteryEntity>>() {
      @Override
      @NonNull
      public List<StudentMasteryEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeId");
          final int _cursorIndexOfMasteryScore = CursorUtil.getColumnIndexOrThrow(_cursor, "masteryScore");
          final int _cursorIndexOfLastUpdateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdateTime");
          final List<StudentMasteryEntity> _result = new ArrayList<StudentMasteryEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StudentMasteryEntity _item;
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final String _tmpNodeId;
            if (_cursor.isNull(_cursorIndexOfNodeId)) {
              _tmpNodeId = null;
            } else {
              _tmpNodeId = _cursor.getString(_cursorIndexOfNodeId);
            }
            final float _tmpMasteryScore;
            _tmpMasteryScore = _cursor.getFloat(_cursorIndexOfMasteryScore);
            final long _tmpLastUpdateTime;
            _tmpLastUpdateTime = _cursor.getLong(_cursorIndexOfLastUpdateTime);
            _item = new StudentMasteryEntity(_tmpStudentId,_tmpNodeId,_tmpMasteryScore,_tmpLastUpdateTime);
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
  public Object getMasterySync(final String studentId, final String nodeId,
      final Continuation<? super StudentMasteryEntity> arg2) {
    final String _sql = "SELECT * FROM student_mastery WHERE studentId = ? AND nodeId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
    }
    _argIndex = 2;
    if (nodeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nodeId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<StudentMasteryEntity>() {
      @Override
      @Nullable
      public StudentMasteryEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeId");
          final int _cursorIndexOfMasteryScore = CursorUtil.getColumnIndexOrThrow(_cursor, "masteryScore");
          final int _cursorIndexOfLastUpdateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdateTime");
          final StudentMasteryEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final String _tmpNodeId;
            if (_cursor.isNull(_cursorIndexOfNodeId)) {
              _tmpNodeId = null;
            } else {
              _tmpNodeId = _cursor.getString(_cursorIndexOfNodeId);
            }
            final float _tmpMasteryScore;
            _tmpMasteryScore = _cursor.getFloat(_cursorIndexOfMasteryScore);
            final long _tmpLastUpdateTime;
            _tmpLastUpdateTime = _cursor.getLong(_cursorIndexOfLastUpdateTime);
            _result = new StudentMasteryEntity(_tmpStudentId,_tmpNodeId,_tmpMasteryScore,_tmpLastUpdateTime);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg2);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
