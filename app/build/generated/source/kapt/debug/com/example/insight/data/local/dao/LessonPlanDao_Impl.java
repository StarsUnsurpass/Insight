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
import com.example.insight.data.local.entities.LessonPlanEntity;
import com.example.insight.data.local.entities.LessonQuestionCrossRef;
import com.example.insight.data.local.entities.ScanRecordEntity;
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
public final class LessonPlanDao_Impl implements LessonPlanDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LessonPlanEntity> __insertionAdapterOfLessonPlanEntity;

  private final EntityInsertionAdapter<LessonQuestionCrossRef> __insertionAdapterOfLessonQuestionCrossRef;

  private final EntityDeletionOrUpdateAdapter<LessonPlanEntity> __deletionAdapterOfLessonPlanEntity;

  private final EntityDeletionOrUpdateAdapter<LessonPlanEntity> __updateAdapterOfLessonPlanEntity;

  public LessonPlanDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLessonPlanEntity = new EntityInsertionAdapter<LessonPlanEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `lesson_plan_table` (`planId`,`title`,`contentMarkdown`,`targetClassName`,`relatedKnowledgeNodeId`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LessonPlanEntity entity) {
        if (entity.getPlanId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPlanId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getContentMarkdown() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContentMarkdown());
        }
        if (entity.getTargetClassName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTargetClassName());
        }
        if (entity.getRelatedKnowledgeNodeId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getRelatedKnowledgeNodeId());
        }
        statement.bindLong(6, entity.getCreatedAt());
        statement.bindLong(7, entity.getUpdatedAt());
      }
    };
    this.__insertionAdapterOfLessonQuestionCrossRef = new EntityInsertionAdapter<LessonQuestionCrossRef>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `lesson_question_cross_ref` (`planId`,`questionId`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LessonQuestionCrossRef entity) {
        if (entity.getPlanId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPlanId());
        }
        if (entity.getQuestionId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getQuestionId());
        }
      }
    };
    this.__deletionAdapterOfLessonPlanEntity = new EntityDeletionOrUpdateAdapter<LessonPlanEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `lesson_plan_table` WHERE `planId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LessonPlanEntity entity) {
        if (entity.getPlanId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPlanId());
        }
      }
    };
    this.__updateAdapterOfLessonPlanEntity = new EntityDeletionOrUpdateAdapter<LessonPlanEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `lesson_plan_table` SET `planId` = ?,`title` = ?,`contentMarkdown` = ?,`targetClassName` = ?,`relatedKnowledgeNodeId` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `planId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LessonPlanEntity entity) {
        if (entity.getPlanId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPlanId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getContentMarkdown() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContentMarkdown());
        }
        if (entity.getTargetClassName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTargetClassName());
        }
        if (entity.getRelatedKnowledgeNodeId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getRelatedKnowledgeNodeId());
        }
        statement.bindLong(6, entity.getCreatedAt());
        statement.bindLong(7, entity.getUpdatedAt());
        if (entity.getPlanId() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPlanId());
        }
      }
    };
  }

  @Override
  public Object insertPlan(final LessonPlanEntity plan,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLessonPlanEntity.insert(plan);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertQuestionRef(final LessonQuestionCrossRef ref,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLessonQuestionCrossRef.insert(ref);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletePlan(final LessonPlanEntity plan,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfLessonPlanEntity.handle(plan);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePlan(final LessonPlanEntity plan,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLessonPlanEntity.handle(plan);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<LessonPlanEntity>> getAllPlansFlow() {
    final String _sql = "SELECT * FROM lesson_plan_table ORDER BY updatedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"lesson_plan_table"}, new Callable<List<LessonPlanEntity>>() {
      @Override
      @NonNull
      public List<LessonPlanEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPlanId = CursorUtil.getColumnIndexOrThrow(_cursor, "planId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContentMarkdown = CursorUtil.getColumnIndexOrThrow(_cursor, "contentMarkdown");
          final int _cursorIndexOfTargetClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "targetClassName");
          final int _cursorIndexOfRelatedKnowledgeNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "relatedKnowledgeNodeId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<LessonPlanEntity> _result = new ArrayList<LessonPlanEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LessonPlanEntity _item;
            final String _tmpPlanId;
            if (_cursor.isNull(_cursorIndexOfPlanId)) {
              _tmpPlanId = null;
            } else {
              _tmpPlanId = _cursor.getString(_cursorIndexOfPlanId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpContentMarkdown;
            if (_cursor.isNull(_cursorIndexOfContentMarkdown)) {
              _tmpContentMarkdown = null;
            } else {
              _tmpContentMarkdown = _cursor.getString(_cursorIndexOfContentMarkdown);
            }
            final String _tmpTargetClassName;
            if (_cursor.isNull(_cursorIndexOfTargetClassName)) {
              _tmpTargetClassName = null;
            } else {
              _tmpTargetClassName = _cursor.getString(_cursorIndexOfTargetClassName);
            }
            final String _tmpRelatedKnowledgeNodeId;
            if (_cursor.isNull(_cursorIndexOfRelatedKnowledgeNodeId)) {
              _tmpRelatedKnowledgeNodeId = null;
            } else {
              _tmpRelatedKnowledgeNodeId = _cursor.getString(_cursorIndexOfRelatedKnowledgeNodeId);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new LessonPlanEntity(_tmpPlanId,_tmpTitle,_tmpContentMarkdown,_tmpTargetClassName,_tmpRelatedKnowledgeNodeId,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getPlanById(final String id,
      final Continuation<? super LessonPlanEntity> $completion) {
    final String _sql = "SELECT * FROM lesson_plan_table WHERE planId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LessonPlanEntity>() {
      @Override
      @Nullable
      public LessonPlanEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPlanId = CursorUtil.getColumnIndexOrThrow(_cursor, "planId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContentMarkdown = CursorUtil.getColumnIndexOrThrow(_cursor, "contentMarkdown");
          final int _cursorIndexOfTargetClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "targetClassName");
          final int _cursorIndexOfRelatedKnowledgeNodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "relatedKnowledgeNodeId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final LessonPlanEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpPlanId;
            if (_cursor.isNull(_cursorIndexOfPlanId)) {
              _tmpPlanId = null;
            } else {
              _tmpPlanId = _cursor.getString(_cursorIndexOfPlanId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpContentMarkdown;
            if (_cursor.isNull(_cursorIndexOfContentMarkdown)) {
              _tmpContentMarkdown = null;
            } else {
              _tmpContentMarkdown = _cursor.getString(_cursorIndexOfContentMarkdown);
            }
            final String _tmpTargetClassName;
            if (_cursor.isNull(_cursorIndexOfTargetClassName)) {
              _tmpTargetClassName = null;
            } else {
              _tmpTargetClassName = _cursor.getString(_cursorIndexOfTargetClassName);
            }
            final String _tmpRelatedKnowledgeNodeId;
            if (_cursor.isNull(_cursorIndexOfRelatedKnowledgeNodeId)) {
              _tmpRelatedKnowledgeNodeId = null;
            } else {
              _tmpRelatedKnowledgeNodeId = _cursor.getString(_cursorIndexOfRelatedKnowledgeNodeId);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new LessonPlanEntity(_tmpPlanId,_tmpTitle,_tmpContentMarkdown,_tmpTargetClassName,_tmpRelatedKnowledgeNodeId,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ScanRecordEntity>> getQuestionsForPlanFlow(final String planId) {
    final String _sql = "\n"
            + "        SELECT scan_record_table.* FROM scan_record_table \n"
            + "        INNER JOIN lesson_question_cross_ref ON scan_record_table.id = lesson_question_cross_ref.questionId \n"
            + "        WHERE lesson_question_cross_ref.planId = ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (planId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, planId);
    }
    return CoroutinesRoom.createFlow(__db, true, new String[] {"scan_record_table",
        "lesson_question_cross_ref"}, new Callable<List<ScanRecordEntity>>() {
      @Override
      @NonNull
      public List<ScanRecordEntity> call() throws Exception {
        __db.beginTransaction();
        try {
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
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
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
