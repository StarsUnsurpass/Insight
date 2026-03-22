package com.example.insight.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.insight.data.local.converters.Converters;
import com.example.insight.data.local.entities.CourseEntity;
import com.example.insight.data.local.entities.LessonTimeEntity;
import com.example.insight.data.local.entities.ScheduleEntity;
import com.example.insight.data.local.entities.TimeSlotEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ScheduleDao_Impl implements ScheduleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ScheduleEntity> __insertionAdapterOfScheduleEntity;

  private final EntityInsertionAdapter<LessonTimeEntity> __insertionAdapterOfLessonTimeEntity;

  private final EntityInsertionAdapter<CourseEntity> __insertionAdapterOfCourseEntity;

  private final EntityInsertionAdapter<TimeSlotEntity> __insertionAdapterOfTimeSlotEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<ScheduleEntity> __deletionAdapterOfScheduleEntity;

  private final EntityDeletionOrUpdateAdapter<CourseEntity> __deletionAdapterOfCourseEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearActiveSchedules;

  private final SharedSQLiteStatement __preparedStmtOfUpdateScheduleActiveStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteLessonTimesByScheduleId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTimeSlotsByCourseId;

  public ScheduleDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfScheduleEntity = new EntityInsertionAdapter<ScheduleEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `schedule_tables` (`scheduleId`,`scheduleName`,`isCurrentActive`,`termStartDate`,`morningLessonCount`,`afternoonLessonCount`,`eveningLessonCount`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ScheduleEntity entity) {
        statement.bindLong(1, entity.getScheduleId());
        if (entity.getScheduleName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getScheduleName());
        }
        final int _tmp = entity.isCurrentActive() ? 1 : 0;
        statement.bindLong(3, _tmp);
        statement.bindLong(4, entity.getTermStartDate());
        statement.bindLong(5, entity.getMorningLessonCount());
        statement.bindLong(6, entity.getAfternoonLessonCount());
        statement.bindLong(7, entity.getEveningLessonCount());
      }
    };
    this.__insertionAdapterOfLessonTimeEntity = new EntityInsertionAdapter<LessonTimeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `lesson_times` (`timeId`,`scheduleId`,`period`,`startTime`,`endTime`,`section`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LessonTimeEntity entity) {
        statement.bindLong(1, entity.getTimeId());
        statement.bindLong(2, entity.getScheduleId());
        statement.bindLong(3, entity.getPeriod());
        if (entity.getStartTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getStartTime());
        }
        if (entity.getEndTime() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getEndTime());
        }
        statement.bindLong(6, entity.getSection());
      }
    };
    this.__insertionAdapterOfCourseEntity = new EntityInsertionAdapter<CourseEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `course_metadata` (`courseId`,`scheduleId`,`courseName`,`teacherName`,`location`,`themeColor`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CourseEntity entity) {
        statement.bindLong(1, entity.getCourseId());
        statement.bindLong(2, entity.getScheduleId());
        if (entity.getCourseName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCourseName());
        }
        if (entity.getTeacherName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTeacherName());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLocation());
        }
        statement.bindLong(6, entity.getThemeColor());
      }
    };
    this.__insertionAdapterOfTimeSlotEntity = new EntityInsertionAdapter<TimeSlotEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `time_slots` (`slotId`,`courseId`,`dayOfWeek`,`startPeriod`,`endPeriod`,`activeWeeks`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TimeSlotEntity entity) {
        statement.bindLong(1, entity.getSlotId());
        statement.bindLong(2, entity.getCourseId());
        statement.bindLong(3, entity.getDayOfWeek());
        statement.bindLong(4, entity.getStartPeriod());
        statement.bindLong(5, entity.getEndPeriod());
        final String _tmp = __converters.fromIntList(entity.getActiveWeeks());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp);
        }
      }
    };
    this.__deletionAdapterOfScheduleEntity = new EntityDeletionOrUpdateAdapter<ScheduleEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `schedule_tables` WHERE `scheduleId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ScheduleEntity entity) {
        statement.bindLong(1, entity.getScheduleId());
      }
    };
    this.__deletionAdapterOfCourseEntity = new EntityDeletionOrUpdateAdapter<CourseEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `course_metadata` WHERE `courseId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CourseEntity entity) {
        statement.bindLong(1, entity.getCourseId());
      }
    };
    this.__preparedStmtOfClearActiveSchedules = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE schedule_tables SET isCurrentActive = 0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateScheduleActiveStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE schedule_tables SET isCurrentActive = ? WHERE scheduleId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteLessonTimesByScheduleId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM lesson_times WHERE scheduleId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteTimeSlotsByCourseId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM time_slots WHERE courseId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertSchedule(final ScheduleEntity schedule,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfScheduleEntity.insertAndReturnId(schedule);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertLessonTime(final LessonTimeEntity time,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLessonTimeEntity.insert(time);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertCourse(final CourseEntity course,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCourseEntity.insertAndReturnId(course);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertTimeSlot(final TimeSlotEntity slot,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTimeSlotEntity.insert(slot);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteSchedule(final ScheduleEntity schedule,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfScheduleEntity.handle(schedule);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteCourse(final CourseEntity course,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCourseEntity.handle(course);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object setActiveSchedule(final long scheduleId,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> ScheduleDao.DefaultImpls.setActiveSchedule(ScheduleDao_Impl.this, scheduleId, __cont), $completion);
  }

  @Override
  public Object clearActiveSchedules(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearActiveSchedules.acquire();
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
          __preparedStmtOfClearActiveSchedules.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateScheduleActiveStatus(final long scheduleId, final boolean isActive,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateScheduleActiveStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isActive ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, scheduleId);
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
          __preparedStmtOfUpdateScheduleActiveStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteLessonTimesByScheduleId(final long scheduleId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteLessonTimesByScheduleId.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, scheduleId);
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
          __preparedStmtOfDeleteLessonTimesByScheduleId.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTimeSlotsByCourseId(final long courseId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTimeSlotsByCourseId.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, courseId);
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
          __preparedStmtOfDeleteTimeSlotsByCourseId.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ScheduleEntity>> getAllSchedules() {
    final String _sql = "SELECT * FROM schedule_tables";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"schedule_tables"}, new Callable<List<ScheduleEntity>>() {
      @Override
      @NonNull
      public List<ScheduleEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfScheduleId = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleId");
          final int _cursorIndexOfScheduleName = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleName");
          final int _cursorIndexOfIsCurrentActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isCurrentActive");
          final int _cursorIndexOfTermStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "termStartDate");
          final int _cursorIndexOfMorningLessonCount = CursorUtil.getColumnIndexOrThrow(_cursor, "morningLessonCount");
          final int _cursorIndexOfAfternoonLessonCount = CursorUtil.getColumnIndexOrThrow(_cursor, "afternoonLessonCount");
          final int _cursorIndexOfEveningLessonCount = CursorUtil.getColumnIndexOrThrow(_cursor, "eveningLessonCount");
          final List<ScheduleEntity> _result = new ArrayList<ScheduleEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ScheduleEntity _item;
            final long _tmpScheduleId;
            _tmpScheduleId = _cursor.getLong(_cursorIndexOfScheduleId);
            final String _tmpScheduleName;
            if (_cursor.isNull(_cursorIndexOfScheduleName)) {
              _tmpScheduleName = null;
            } else {
              _tmpScheduleName = _cursor.getString(_cursorIndexOfScheduleName);
            }
            final boolean _tmpIsCurrentActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCurrentActive);
            _tmpIsCurrentActive = _tmp != 0;
            final long _tmpTermStartDate;
            _tmpTermStartDate = _cursor.getLong(_cursorIndexOfTermStartDate);
            final int _tmpMorningLessonCount;
            _tmpMorningLessonCount = _cursor.getInt(_cursorIndexOfMorningLessonCount);
            final int _tmpAfternoonLessonCount;
            _tmpAfternoonLessonCount = _cursor.getInt(_cursorIndexOfAfternoonLessonCount);
            final int _tmpEveningLessonCount;
            _tmpEveningLessonCount = _cursor.getInt(_cursorIndexOfEveningLessonCount);
            _item = new ScheduleEntity(_tmpScheduleId,_tmpScheduleName,_tmpIsCurrentActive,_tmpTermStartDate,_tmpMorningLessonCount,_tmpAfternoonLessonCount,_tmpEveningLessonCount);
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
  public Flow<ScheduleEntity> getActiveSchedule() {
    final String _sql = "SELECT * FROM schedule_tables WHERE isCurrentActive = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"schedule_tables"}, new Callable<ScheduleEntity>() {
      @Override
      @Nullable
      public ScheduleEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfScheduleId = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleId");
          final int _cursorIndexOfScheduleName = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleName");
          final int _cursorIndexOfIsCurrentActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isCurrentActive");
          final int _cursorIndexOfTermStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "termStartDate");
          final int _cursorIndexOfMorningLessonCount = CursorUtil.getColumnIndexOrThrow(_cursor, "morningLessonCount");
          final int _cursorIndexOfAfternoonLessonCount = CursorUtil.getColumnIndexOrThrow(_cursor, "afternoonLessonCount");
          final int _cursorIndexOfEveningLessonCount = CursorUtil.getColumnIndexOrThrow(_cursor, "eveningLessonCount");
          final ScheduleEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpScheduleId;
            _tmpScheduleId = _cursor.getLong(_cursorIndexOfScheduleId);
            final String _tmpScheduleName;
            if (_cursor.isNull(_cursorIndexOfScheduleName)) {
              _tmpScheduleName = null;
            } else {
              _tmpScheduleName = _cursor.getString(_cursorIndexOfScheduleName);
            }
            final boolean _tmpIsCurrentActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCurrentActive);
            _tmpIsCurrentActive = _tmp != 0;
            final long _tmpTermStartDate;
            _tmpTermStartDate = _cursor.getLong(_cursorIndexOfTermStartDate);
            final int _tmpMorningLessonCount;
            _tmpMorningLessonCount = _cursor.getInt(_cursorIndexOfMorningLessonCount);
            final int _tmpAfternoonLessonCount;
            _tmpAfternoonLessonCount = _cursor.getInt(_cursorIndexOfAfternoonLessonCount);
            final int _tmpEveningLessonCount;
            _tmpEveningLessonCount = _cursor.getInt(_cursorIndexOfEveningLessonCount);
            _result = new ScheduleEntity(_tmpScheduleId,_tmpScheduleName,_tmpIsCurrentActive,_tmpTermStartDate,_tmpMorningLessonCount,_tmpAfternoonLessonCount,_tmpEveningLessonCount);
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
  public Flow<List<LessonTimeEntity>> getLessonTimes(final long scheduleId) {
    final String _sql = "SELECT * FROM lesson_times WHERE scheduleId = ? ORDER BY period ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, scheduleId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"lesson_times"}, new Callable<List<LessonTimeEntity>>() {
      @Override
      @NonNull
      public List<LessonTimeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTimeId = CursorUtil.getColumnIndexOrThrow(_cursor, "timeId");
          final int _cursorIndexOfScheduleId = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleId");
          final int _cursorIndexOfPeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "period");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfSection = CursorUtil.getColumnIndexOrThrow(_cursor, "section");
          final List<LessonTimeEntity> _result = new ArrayList<LessonTimeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LessonTimeEntity _item;
            final long _tmpTimeId;
            _tmpTimeId = _cursor.getLong(_cursorIndexOfTimeId);
            final long _tmpScheduleId;
            _tmpScheduleId = _cursor.getLong(_cursorIndexOfScheduleId);
            final int _tmpPeriod;
            _tmpPeriod = _cursor.getInt(_cursorIndexOfPeriod);
            final String _tmpStartTime;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmpStartTime = null;
            } else {
              _tmpStartTime = _cursor.getString(_cursorIndexOfStartTime);
            }
            final String _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getString(_cursorIndexOfEndTime);
            }
            final int _tmpSection;
            _tmpSection = _cursor.getInt(_cursorIndexOfSection);
            _item = new LessonTimeEntity(_tmpTimeId,_tmpScheduleId,_tmpPeriod,_tmpStartTime,_tmpEndTime,_tmpSection);
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
  public Flow<List<CourseEntity>> getCoursesForSchedule(final long scheduleId) {
    final String _sql = "SELECT * FROM course_metadata WHERE scheduleId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, scheduleId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"course_metadata"}, new Callable<List<CourseEntity>>() {
      @Override
      @NonNull
      public List<CourseEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCourseId = CursorUtil.getColumnIndexOrThrow(_cursor, "courseId");
          final int _cursorIndexOfScheduleId = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleId");
          final int _cursorIndexOfCourseName = CursorUtil.getColumnIndexOrThrow(_cursor, "courseName");
          final int _cursorIndexOfTeacherName = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherName");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfThemeColor = CursorUtil.getColumnIndexOrThrow(_cursor, "themeColor");
          final List<CourseEntity> _result = new ArrayList<CourseEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CourseEntity _item;
            final long _tmpCourseId;
            _tmpCourseId = _cursor.getLong(_cursorIndexOfCourseId);
            final long _tmpScheduleId;
            _tmpScheduleId = _cursor.getLong(_cursorIndexOfScheduleId);
            final String _tmpCourseName;
            if (_cursor.isNull(_cursorIndexOfCourseName)) {
              _tmpCourseName = null;
            } else {
              _tmpCourseName = _cursor.getString(_cursorIndexOfCourseName);
            }
            final String _tmpTeacherName;
            if (_cursor.isNull(_cursorIndexOfTeacherName)) {
              _tmpTeacherName = null;
            } else {
              _tmpTeacherName = _cursor.getString(_cursorIndexOfTeacherName);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final int _tmpThemeColor;
            _tmpThemeColor = _cursor.getInt(_cursorIndexOfThemeColor);
            _item = new CourseEntity(_tmpCourseId,_tmpScheduleId,_tmpCourseName,_tmpTeacherName,_tmpLocation,_tmpThemeColor);
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
  public Object getTimeSlotsForCourse(final long courseId,
      final Continuation<? super List<TimeSlotEntity>> $completion) {
    final String _sql = "SELECT * FROM time_slots WHERE courseId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, courseId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TimeSlotEntity>>() {
      @Override
      @NonNull
      public List<TimeSlotEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSlotId = CursorUtil.getColumnIndexOrThrow(_cursor, "slotId");
          final int _cursorIndexOfCourseId = CursorUtil.getColumnIndexOrThrow(_cursor, "courseId");
          final int _cursorIndexOfDayOfWeek = CursorUtil.getColumnIndexOrThrow(_cursor, "dayOfWeek");
          final int _cursorIndexOfStartPeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "startPeriod");
          final int _cursorIndexOfEndPeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "endPeriod");
          final int _cursorIndexOfActiveWeeks = CursorUtil.getColumnIndexOrThrow(_cursor, "activeWeeks");
          final List<TimeSlotEntity> _result = new ArrayList<TimeSlotEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TimeSlotEntity _item;
            final long _tmpSlotId;
            _tmpSlotId = _cursor.getLong(_cursorIndexOfSlotId);
            final long _tmpCourseId;
            _tmpCourseId = _cursor.getLong(_cursorIndexOfCourseId);
            final int _tmpDayOfWeek;
            _tmpDayOfWeek = _cursor.getInt(_cursorIndexOfDayOfWeek);
            final int _tmpStartPeriod;
            _tmpStartPeriod = _cursor.getInt(_cursorIndexOfStartPeriod);
            final int _tmpEndPeriod;
            _tmpEndPeriod = _cursor.getInt(_cursorIndexOfEndPeriod);
            final List<Integer> _tmpActiveWeeks;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfActiveWeeks)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfActiveWeeks);
            }
            _tmpActiveWeeks = __converters.toIntList(_tmp);
            _item = new TimeSlotEntity(_tmpSlotId,_tmpCourseId,_tmpDayOfWeek,_tmpStartPeriod,_tmpEndPeriod,_tmpActiveWeeks);
            _result.add(_item);
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
  public Flow<List<CourseWithTimeSlot>> getFullScheduleData(final long scheduleId) {
    final String _sql = "\n"
            + "        SELECT * FROM course_metadata \n"
            + "        JOIN time_slots ON course_metadata.courseId = time_slots.courseId \n"
            + "        WHERE course_metadata.scheduleId = ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, scheduleId);
    return CoroutinesRoom.createFlow(__db, true, new String[] {"time_slots",
        "course_metadata"}, new Callable<List<CourseWithTimeSlot>>() {
      @Override
      @NonNull
      public List<CourseWithTimeSlot> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfCourseId = CursorUtil.getColumnIndexOrThrow(_cursor, "courseId");
            final int _cursorIndexOfScheduleId = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleId");
            final int _cursorIndexOfCourseName = CursorUtil.getColumnIndexOrThrow(_cursor, "courseName");
            final int _cursorIndexOfTeacherName = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherName");
            final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
            final int _cursorIndexOfThemeColor = CursorUtil.getColumnIndexOrThrow(_cursor, "themeColor");
            final LongSparseArray<ArrayList<TimeSlotEntity>> _collectionTimeSlots = new LongSparseArray<ArrayList<TimeSlotEntity>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey;
              _tmpKey = _cursor.getLong(_cursorIndexOfCourseId);
              if (!_collectionTimeSlots.containsKey(_tmpKey)) {
                _collectionTimeSlots.put(_tmpKey, new ArrayList<TimeSlotEntity>());
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptimeSlotsAscomExampleInsightDataLocalEntitiesTimeSlotEntity(_collectionTimeSlots);
            final List<CourseWithTimeSlot> _result = new ArrayList<CourseWithTimeSlot>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final CourseWithTimeSlot _item;
              final CourseEntity _tmpCourse;
              final long _tmpCourseId;
              _tmpCourseId = _cursor.getLong(_cursorIndexOfCourseId);
              final long _tmpScheduleId;
              _tmpScheduleId = _cursor.getLong(_cursorIndexOfScheduleId);
              final String _tmpCourseName;
              if (_cursor.isNull(_cursorIndexOfCourseName)) {
                _tmpCourseName = null;
              } else {
                _tmpCourseName = _cursor.getString(_cursorIndexOfCourseName);
              }
              final String _tmpTeacherName;
              if (_cursor.isNull(_cursorIndexOfTeacherName)) {
                _tmpTeacherName = null;
              } else {
                _tmpTeacherName = _cursor.getString(_cursorIndexOfTeacherName);
              }
              final String _tmpLocation;
              if (_cursor.isNull(_cursorIndexOfLocation)) {
                _tmpLocation = null;
              } else {
                _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
              }
              final int _tmpThemeColor;
              _tmpThemeColor = _cursor.getInt(_cursorIndexOfThemeColor);
              _tmpCourse = new CourseEntity(_tmpCourseId,_tmpScheduleId,_tmpCourseName,_tmpTeacherName,_tmpLocation,_tmpThemeColor);
              final ArrayList<TimeSlotEntity> _tmpTimeSlotsCollection;
              final long _tmpKey_1;
              _tmpKey_1 = _cursor.getLong(_cursorIndexOfCourseId);
              _tmpTimeSlotsCollection = _collectionTimeSlots.get(_tmpKey_1);
              _item = new CourseWithTimeSlot(_tmpCourse,_tmpTimeSlotsCollection);
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

  private void __fetchRelationshiptimeSlotsAscomExampleInsightDataLocalEntitiesTimeSlotEntity(
      @NonNull final LongSparseArray<ArrayList<TimeSlotEntity>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchLongSparseArray(_map, true, (map) -> {
        __fetchRelationshiptimeSlotsAscomExampleInsightDataLocalEntitiesTimeSlotEntity(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `slotId`,`courseId`,`dayOfWeek`,`startPeriod`,`endPeriod`,`activeWeeks` FROM `time_slots` WHERE `courseId` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      final long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "courseId");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfSlotId = 0;
      final int _cursorIndexOfCourseId = 1;
      final int _cursorIndexOfDayOfWeek = 2;
      final int _cursorIndexOfStartPeriod = 3;
      final int _cursorIndexOfEndPeriod = 4;
      final int _cursorIndexOfActiveWeeks = 5;
      while (_cursor.moveToNext()) {
        final long _tmpKey;
        _tmpKey = _cursor.getLong(_itemKeyIndex);
        final ArrayList<TimeSlotEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final TimeSlotEntity _item_1;
          final long _tmpSlotId;
          _tmpSlotId = _cursor.getLong(_cursorIndexOfSlotId);
          final long _tmpCourseId;
          _tmpCourseId = _cursor.getLong(_cursorIndexOfCourseId);
          final int _tmpDayOfWeek;
          _tmpDayOfWeek = _cursor.getInt(_cursorIndexOfDayOfWeek);
          final int _tmpStartPeriod;
          _tmpStartPeriod = _cursor.getInt(_cursorIndexOfStartPeriod);
          final int _tmpEndPeriod;
          _tmpEndPeriod = _cursor.getInt(_cursorIndexOfEndPeriod);
          final List<Integer> _tmpActiveWeeks;
          final String _tmp;
          if (_cursor.isNull(_cursorIndexOfActiveWeeks)) {
            _tmp = null;
          } else {
            _tmp = _cursor.getString(_cursorIndexOfActiveWeeks);
          }
          _tmpActiveWeeks = __converters.toIntList(_tmp);
          _item_1 = new TimeSlotEntity(_tmpSlotId,_tmpCourseId,_tmpDayOfWeek,_tmpStartPeriod,_tmpEndPeriod,_tmpActiveWeeks);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
