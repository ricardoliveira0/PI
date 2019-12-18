import java.time.DayOfWeek
import java.time.LocalDate

import java.util.*

class Meetup(private val month: Int, private val year: Int) {
    fun day(dayOfWeek: DayOfWeek, meetupSchedule: MeetupSchedule): LocalDate {
        val calender = Calendar.getInstance()
        with(calender)
        {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month - 1)
            set(Calendar.DAY_OF_WEEK_IN_MONTH, 1)
            set(Calendar.DAY_OF_WEEK, dayOfWeek.toInt())

            when (meetupSchedule) {
                MeetupSchedule.FIRST -> Unit
                MeetupSchedule.SECOND -> {
                    add(Calendar.WEEK_OF_MONTH, 1)
                }
                MeetupSchedule.THIRD -> {
                    add(Calendar.WEEK_OF_MONTH, 2)
                }
                MeetupSchedule.FOURTH -> {
                    add(Calendar.WEEK_OF_MONTH, 3)
                }
                MeetupSchedule.TEENTH -> {
                    for (day in 13..20) {
                        set(Calendar.DATE, day)
                        get(Calendar.DAY_OF_WEEK)
                        dayOfWeek.value
                        if (get(Calendar.DAY_OF_WEEK) == dayOfWeek.toInt())
                            break
                    }
                }
                MeetupSchedule.LAST -> {
                    val totalWeeks = getActualMaximum(Calendar.DAY_OF_WEEK_IN_MONTH)
                    val totalDays = getActualMaximum(Calendar.DAY_OF_MONTH)
                    val currentDate = get(Calendar.DATE)
                    if (totalWeeks * 7 + currentDate > totalDays)
                        add(Calendar.WEEK_OF_MONTH, totalWeeks - 1)
                    else
                        add(Calendar.WEEK_OF_MONTH, totalWeeks)
                }

            }
            return LocalDate.of(year, month, this.get(Calendar.DATE))

        }

    }

    private fun DayOfWeek.toInt(): Int {
        return when (this) {
            DayOfWeek.SUNDAY -> 1
            DayOfWeek.MONDAY -> 2
            DayOfWeek.TUESDAY -> 3
            DayOfWeek.WEDNESDAY -> 4
            DayOfWeek.THURSDAY -> 5
            DayOfWeek.FRIDAY -> 6
            DayOfWeek.SATURDAY -> 7
        }
    }
}