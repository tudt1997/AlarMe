
package com.e15cn1.alarme.alarms.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.e15cn1.alarme.alarms.Alarm;
import com.e15cn1.alarme.data.DatabaseTableManager;

import static com.e15cn1.alarme.alarms.misc.DaysOfWeek.FRIDAY;
import static com.e15cn1.alarme.alarms.misc.DaysOfWeek.MONDAY;
import static com.e15cn1.alarme.alarms.misc.DaysOfWeek.SATURDAY;
import static com.e15cn1.alarme.alarms.misc.DaysOfWeek.SUNDAY;
import static com.e15cn1.alarme.alarms.misc.DaysOfWeek.THURSDAY;
import static com.e15cn1.alarme.alarms.misc.DaysOfWeek.TUESDAY;
import static com.e15cn1.alarme.alarms.misc.DaysOfWeek.WEDNESDAY;

public class AlarmsTableManager extends DatabaseTableManager<Alarm> {

    public AlarmsTableManager(Context context) {
        super(context);
    }

    @Override
    protected String getQuerySortOrder() {
        return AlarmsTable.NEW_SORT_ORDER;
    }

    @Override
    public AlarmCursor queryItem(long id) {
        return wrapInAlarmCursor(super.queryItem(id));
    }

    @Override
    public AlarmCursor queryItems() {
        return wrapInAlarmCursor(super.queryItems());
    }

    public AlarmCursor queryEnabledAlarms() {
        return queryItems(AlarmsTable.COLUMN_ENABLED + " = 1", null);
    }

    @Override
    protected AlarmCursor queryItems(String where, String limit) {
        return wrapInAlarmCursor(super.queryItems(where, limit));
    }

    @Override
    protected String getTableName() {
        return AlarmsTable.TABLE_ALARMS;
    }

    @Override
    protected ContentValues toContentValues(Alarm alarm) {
        ContentValues values = new ContentValues();
        values.put(AlarmsTable.COLUMN_HOUR, alarm.hour());
        values.put(AlarmsTable.COLUMN_MINUTES, alarm.minutes());
        values.put(AlarmsTable.COLUMN_LABEL, alarm.label());
        values.put(AlarmsTable.COLUMN_RINGTONE, alarm.ringtone());
        values.put(AlarmsTable.COLUMN_VIBRATES, alarm.vibrates());
        values.put(AlarmsTable.COLUMN_ENABLED, alarm.isEnabled());
        values.put(AlarmsTable.COLUMN_RING_TIME_MILLIS, alarm.ringsAt());
        values.put(AlarmsTable.COLUMN_SNOOZING_UNTIL_MILLIS, alarm.snoozingUntil());
        values.put(AlarmsTable.COLUMN_SUNDAY, alarm.isRecurring(SUNDAY));
        values.put(AlarmsTable.COLUMN_MONDAY, alarm.isRecurring(MONDAY));
        values.put(AlarmsTable.COLUMN_TUESDAY, alarm.isRecurring(TUESDAY));
        values.put(AlarmsTable.COLUMN_WEDNESDAY, alarm.isRecurring(WEDNESDAY));
        values.put(AlarmsTable.COLUMN_THURSDAY, alarm.isRecurring(THURSDAY));
        values.put(AlarmsTable.COLUMN_FRIDAY, alarm.isRecurring(FRIDAY));
        values.put(AlarmsTable.COLUMN_SATURDAY, alarm.isRecurring(SATURDAY));
        values.put(AlarmsTable.COLUMN_IGNORE_UPCOMING_RING_TIME, alarm.isIgnoringUpcomingRingTime());
        return values;
    }

    @Override
    protected String getOnContentChangeAction() {
        return AlarmsListCursorLoader.ACTION_CHANGE_CONTENT;
    }

    private AlarmCursor wrapInAlarmCursor(Cursor c) {
        return new AlarmCursor(c);
    }
}
