package com.example.insight.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.insight.data.local.entities.ScanRecordEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class ScanDao_Impl implements ScanDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ScanRecordEntity> __insertionAdapterOfScanRecordEntity;

  public ScanDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfScanRecordEntity = new EntityInsertionAdapter<ScanRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `scan_record_table` (`id`,`originalImagePath`,`ocrText`,`llmAnalysisJson`,`coreKnowledgeId`,`studentId`,`isMastered`,`createdAt`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ScanRecordEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getOriginalImagePath() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getOriginalImagePath());
        }
        if (entity.getOcrText() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getOcrText());
        }
        if (entity.getLlmAnalysisJson() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLlmAnalysisJson());
        }
        if (entity.getCoreKnowledgeId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCoreKnowledgeId());
        }
        if (entity.getStudentId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStudentId());
        }
        final int _tmp = entity.isMastered() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getCreatedAt());
      }
    };
  }

  @Override
  public Object insertScanRecord(final ScanRecordEntity record,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfScanRecordEntity.insert(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Flow<List<ScanRecordEntity>> getAllScansFlow() {
    final String _sql = "SELECT * FROM scan_record_table ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"scan_record_table"}, new Callable<List<ScanRecordEntity>>() {
      @Override
      @NonNull
      public List<ScanRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "originalImagePath");
          final int _cursorIndexOfOcrText = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrText");
          final int _cursorIndexOfLlmAnalysisJson = CursorUtil.getColumnIndexOrThrow(_cursor, "llmAnalysisJson");
          final int _cursorIndexOfCoreKnowledgeId = CursorUtil.getColumnIndexOrThrow(_cursor, "coreKnowledgeId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfIsMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "isMastered");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<ScanRecordEntity> _result = new ArrayList<ScanRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ScanRecordEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpOriginalImagePath;
            if (_cursor.isNull(_cursorIndexOfOriginalImagePath)) {
              _tmpOriginalImagePath = null;
            } else {
              _tmpOriginalImagePath = _cursor.getString(_cursorIndexOfOriginalImagePath);
            }
            final String _tmpOcrText;
            if (_cursor.isNull(_cursorIndexOfOcrText)) {
              _tmpOcrText = null;
            } else {
              _tmpOcrText = _cursor.getString(_cursorIndexOfOcrText);
            }
            final String _tmpLlmAnalysisJson;
            if (_cursor.isNull(_cursorIndexOfLlmAnalysisJson)) {
              _tmpLlmAnalysisJson = null;
            } else {
              _tmpLlmAnalysisJson = _cursor.getString(_cursorIndexOfLlmAnalysisJson);
            }
            final String _tmpCoreKnowledgeId;
            if (_cursor.isNull(_cursorIndexOfCoreKnowledgeId)) {
              _tmpCoreKnowledgeId = null;
            } else {
              _tmpCoreKnowledgeId = _cursor.getString(_cursorIndexOfCoreKnowledgeId);
            }
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final boolean _tmpIsMastered;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMastered);
            _tmpIsMastered = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new ScanRecordEntity(_tmpId,_tmpOriginalImagePath,_tmpOcrText,_tmpLlmAnalysisJson,_tmpCoreKnowledgeId,_tmpStudentId,_tmpIsMastered,_tmpCreatedAt);
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
  public Flow<List<ScanRecordEntity>> getScansByStudentFlow(final String studentId) {
    final String _sql = "SELECT * FROM scan_record_table WHERE studentId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (studentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, studentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"scan_record_table"}, new Callable<List<ScanRecordEntity>>() {
      @Override
      @NonNull
      public List<ScanRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "originalImagePath");
          final int _cursorIndexOfOcrText = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrText");
          final int _cursorIndexOfLlmAnalysisJson = CursorUtil.getColumnIndexOrThrow(_cursor, "llmAnalysisJson");
          final int _cursorIndexOfCoreKnowledgeId = CursorUtil.getColumnIndexOrThrow(_cursor, "coreKnowledgeId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfIsMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "isMastered");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<ScanRecordEntity> _result = new ArrayList<ScanRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ScanRecordEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpOriginalImagePath;
            if (_cursor.isNull(_cursorIndexOfOriginalImagePath)) {
              _tmpOriginalImagePath = null;
            } else {
              _tmpOriginalImagePath = _cursor.getString(_cursorIndexOfOriginalImagePath);
            }
            final String _tmpOcrText;
            if (_cursor.isNull(_cursorIndexOfOcrText)) {
              _tmpOcrText = null;
            } else {
              _tmpOcrText = _cursor.getString(_cursorIndexOfOcrText);
            }
            final String _tmpLlmAnalysisJson;
            if (_cursor.isNull(_cursorIndexOfLlmAnalysisJson)) {
              _tmpLlmAnalysisJson = null;
            } else {
              _tmpLlmAnalysisJson = _cursor.getString(_cursorIndexOfLlmAnalysisJson);
            }
            final String _tmpCoreKnowledgeId;
            if (_cursor.isNull(_cursorIndexOfCoreKnowledgeId)) {
              _tmpCoreKnowledgeId = null;
            } else {
              _tmpCoreKnowledgeId = _cursor.getString(_cursorIndexOfCoreKnowledgeId);
            }
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final boolean _tmpIsMastered;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMastered);
            _tmpIsMastered = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new ScanRecordEntity(_tmpId,_tmpOriginalImagePath,_tmpOcrText,_tmpLlmAnalysisJson,_tmpCoreKnowledgeId,_tmpStudentId,_tmpIsMastered,_tmpCreatedAt);
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
  public Object getAllScans(final Continuation<? super List<ScanRecordEntity>> arg0) {
    final String _sql = "SELECT * FROM scan_record_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ScanRecordEntity>>() {
      @Override
      @NonNull
      public List<ScanRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "originalImagePath");
          final int _cursorIndexOfOcrText = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrText");
          final int _cursorIndexOfLlmAnalysisJson = CursorUtil.getColumnIndexOrThrow(_cursor, "llmAnalysisJson");
          final int _cursorIndexOfCoreKnowledgeId = CursorUtil.getColumnIndexOrThrow(_cursor, "coreKnowledgeId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfIsMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "isMastered");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<ScanRecordEntity> _result = new ArrayList<ScanRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ScanRecordEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpOriginalImagePath;
            if (_cursor.isNull(_cursorIndexOfOriginalImagePath)) {
              _tmpOriginalImagePath = null;
            } else {
              _tmpOriginalImagePath = _cursor.getString(_cursorIndexOfOriginalImagePath);
            }
            final String _tmpOcrText;
            if (_cursor.isNull(_cursorIndexOfOcrText)) {
              _tmpOcrText = null;
            } else {
              _tmpOcrText = _cursor.getString(_cursorIndexOfOcrText);
            }
            final String _tmpLlmAnalysisJson;
            if (_cursor.isNull(_cursorIndexOfLlmAnalysisJson)) {
              _tmpLlmAnalysisJson = null;
            } else {
              _tmpLlmAnalysisJson = _cursor.getString(_cursorIndexOfLlmAnalysisJson);
            }
            final String _tmpCoreKnowledgeId;
            if (_cursor.isNull(_cursorIndexOfCoreKnowledgeId)) {
              _tmpCoreKnowledgeId = null;
            } else {
              _tmpCoreKnowledgeId = _cursor.getString(_cursorIndexOfCoreKnowledgeId);
            }
            final String _tmpStudentId;
            if (_cursor.isNull(_cursorIndexOfStudentId)) {
              _tmpStudentId = null;
            } else {
              _tmpStudentId = _cursor.getString(_cursorIndexOfStudentId);
            }
            final boolean _tmpIsMastered;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMastered);
            _tmpIsMastered = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new ScanRecordEntity(_tmpId,_tmpOriginalImagePath,_tmpOcrText,_tmpLlmAnalysisJson,_tmpCoreKnowledgeId,_tmpStudentId,_tmpIsMastered,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg0);
  }

  @Override
  public Flow<Integer> getScanCountFlow() {
    final String _sql = "SELECT COUNT(*) FROM scan_record_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"scan_record_table"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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
  public Flow<Integer> getMasteredCountFlow() {
    final String _sql = "SELECT COUNT(*) FROM scan_record_table WHERE isMastered = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"scan_record_table"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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
