package com.example.insight.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.insight.data.local.entities.KnowledgeEdgeEntity;
import com.example.insight.data.local.entities.KnowledgeNodeEntity;
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

  private final SharedSQLiteStatement __preparedStmtOfUpdateMastery;

  public KnowledgeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKnowledgeNodeEntity = new EntityInsertionAdapter<KnowledgeNodeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `knowledge_node_table` (`nodeId`,`title`,`masteryLevel`,`canvasX`,`canvasY`) VALUES (?,?,?,?,?)";
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
        statement.bindDouble(3, entity.getMasteryLevel());
        statement.bindDouble(4, entity.getCanvasX());
        statement.bindDouble(5, entity.getCanvasY());
      }
    };
    this.__insertionAdapterOfKnowledgeEdgeEntity = new EntityInsertionAdapter<KnowledgeEdgeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `knowledge_edge_table` (`edgeId`,`fromNodeId`,`toNodeId`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final KnowledgeEdgeEntity entity) {
        statement.bindLong(1, entity.getEdgeId());
        if (entity.getFromNodeId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getFromNodeId());
        }
        if (entity.getToNodeId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getToNodeId());
        }
      }
    };
    this.__preparedStmtOfUpdateMastery = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE knowledge_node_table SET masteryLevel = ? WHERE nodeId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertNodes(final List<KnowledgeNodeEntity> nodes,
      final Continuation<? super Unit> $completion) {
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
    }, $completion);
  }

  @Override
  public Object insertEdges(final List<KnowledgeEdgeEntity> edges,
      final Continuation<? super Unit> $completion) {
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
    }, $completion);
  }

  @Override
  public Object updateMastery(final String id, final float level,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMastery.acquire();
        int _argIndex = 1;
        _stmt.bindDouble(_argIndex, level);
        _argIndex = 2;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateMastery.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<KnowledgeNodeEntity>> getAllNodesFlow() {
    final String _sql = "SELECT * FROM knowledge_node_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"knowledge_node_table"}, new Callable<List<KnowledgeNodeEntity>>() {
      @Override
      @NonNull
      public List<KnowledgeNodeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfMasteryLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "masteryLevel");
          final int _cursorIndexOfCanvasX = CursorUtil.getColumnIndexOrThrow(_cursor, "canvasX");
          final int _cursorIndexOfCanvasY = CursorUtil.getColumnIndexOrThrow(_cursor, "canvasY");
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
            final float _tmpMasteryLevel;
            _tmpMasteryLevel = _cursor.getFloat(_cursorIndexOfMasteryLevel);
            final float _tmpCanvasX;
            _tmpCanvasX = _cursor.getFloat(_cursorIndexOfCanvasX);
            final float _tmpCanvasY;
            _tmpCanvasY = _cursor.getFloat(_cursorIndexOfCanvasY);
            _item = new KnowledgeNodeEntity(_tmpNodeId,_tmpTitle,_tmpMasteryLevel,_tmpCanvasX,_tmpCanvasY);
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
  public Flow<List<KnowledgeEdgeEntity>> getAllEdgesFlow() {
    final String _sql = "SELECT * FROM knowledge_edge_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"knowledge_edge_table"}, new Callable<List<KnowledgeEdgeEntity>>() {
      @Override
      @NonNull
      public List<KnowledgeEdgeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEdgeId = CursorUtil.getColumnIndexOrThrow(_cursor, "edgeId");
          final int _cursorIndexOfFromNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "fromNodeId");
          final int _cursorIndexOfToNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "toNodeId");
          final List<KnowledgeEdgeEntity> _result = new ArrayList<KnowledgeEdgeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KnowledgeEdgeEntity _item;
            final int _tmpEdgeId;
            _tmpEdgeId = _cursor.getInt(_cursorIndexOfEdgeId);
            final String _tmpFromNodeId;
            if (_cursor.isNull(_cursorIndexOfFromNodeId)) {
              _tmpFromNodeId = null;
            } else {
              _tmpFromNodeId = _cursor.getString(_cursorIndexOfFromNodeId);
            }
            final String _tmpToNodeId;
            if (_cursor.isNull(_cursorIndexOfToNodeId)) {
              _tmpToNodeId = null;
            } else {
              _tmpToNodeId = _cursor.getString(_cursorIndexOfToNodeId);
            }
            _item = new KnowledgeEdgeEntity(_tmpEdgeId,_tmpFromNodeId,_tmpToNodeId);
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
