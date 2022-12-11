import csv

days = ['Vreme', 'Ponedeljak', 'Utorak', 'Sreda', 'Četvrtak', 'Petak']
terms = ["9:50-10:30", "10:40-11:20", "11:30-12:10", "12:20-13:00",
         "13:10-13:50", "14:00-14:40", "14:50-15:30", "15:40-16:20", "16:30-17:10",
         "17:20-18:00", "18:10-18:50", "19:00-19:40"]

courses = {"CS322": 5, "CS324": 6, "IT381": 6, "OM350": 4}


def main():
    terms_schedule = []
    cs322 = cs324 = it381 = om350 = False
    with open('schedule.csv', 'w', encoding="UTF-8") as schedule:
        inpt = csv.writer(schedule)
        inpt.writerow(days)

        for time in terms:
            terms_schedule.append(time)

            if "9:50" in time:
                cs324 = True
            if "12:20" in time:
                om350 = True
            if "14:00" in time:
                it381 = True
            if "15:40" in time:
                cs322 = True

            if it381:
                if courses.get("IT381") > 0:
                    terms_schedule.append("IT381")
                    courses.update(
                        {"IT381": courses.get("IT381") - 1})
                else:
                    it381 = False
                    terms_schedule.append("x")
            else:
                terms_schedule.append("x")

            if cs324:
                if courses.get("CS324") > 0:
                    terms_schedule.append("CS324")
                    courses.update(
                        {"CS324": courses.get("CS324") - 1})
                else:
                    cs324 = False
                    terms_schedule.append("x")
            else:
                terms_schedule.append("x")

            terms_schedule.append("x")

            if om350:
                if courses.get("OM350") > 0:
                    terms_schedule.append("OM350")
                    courses.update(
                        {"OM350": courses.get("OM350") - 1})
                else:
                    om350 = False

            if cs322:
                if courses.get("CS322") > 0:
                    terms_schedule.append("CS322")
                    courses.update(
                        {"CS322": courses.get("CS322") - 1})
                else:
                    cs322 = False
            else:
                if not om350:
                    terms_schedule.append("x")

            terms_schedule.append("x")
            inpt.writerow(terms_schedule)
            terms_schedule.clear()


if __name__ == '__main__':
    main()
