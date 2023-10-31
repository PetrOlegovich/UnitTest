import pytest
from Average import Average


def test_compare_first_greater():
    comparer = Average([4, 5, 6],
                       [1, 2, 3])

    result = comparer.compare()
    assert result == "Первый список имеет большее среднее значение"


def test_compare_second_greater():
    comparer = Average([1, 2, 3],
                       [4, 5, 6])

    result = comparer.compare()
    assert result == "Второй список имеет большее среднее значение"


def test_compare_equal():
    comparer = Average([1, 2, 3],
                       [1, 2, 3])

    result = comparer.compare()
    assert result == "Средние значения равны"


def test_compare_lists_empty_lists():
    comparer = Average([], [])
    result = comparer.compare()
    assert result == "Средние значения равны"