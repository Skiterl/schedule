package ru.skitel.schedule.modules.record;

public record ScheduleRecordRequest(
        String parity,
        int subgroup_id,
        int subject_id,
        int teacher_id,
        String dayWeek,
        String timeStart,
        String timeEnd,
        String classroom
) {
}
