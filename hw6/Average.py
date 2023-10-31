class Average:

    def __init__(self, list1, list2):
        self.list1 = list1
        self.list2 = list2

    def average(self, list):
        if len(list) == 0:
            return 0
        return sum(list) / len(list)

    def compare(self):
        avg1 = self.average(self.list1)
        avg2 = self.average(self.list2)

        if avg1 > avg2:
            return "Первый список имеет большее среднее значение"
        if avg2 > avg1:
            return "Второй список имеет большее среднее значение"
        return "Средние значения равны"