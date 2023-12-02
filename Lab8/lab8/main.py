from Calculation import CalculateTheEquation

if __name__ == "__main__":
    value_to_write = -1.2
    calc = CalculateTheEquation()
    calc.set_variable(value_to_write)

    try:
        calc.write_result_to_txt("txt.txt")
        print("Значення успішно записано у текстовий файл.")
        calc.write_result_to_bin("bin.bin")
        print("Значення успішно записано у бінарний файл.")
    except IOError as e:
        print("Помилка при записі у файл:", e)

    calc1 = CalculateTheEquation()
    try:
        calc1.read_result_from_bin("bin.bin")
        print("Результат обчислення:", calc1.do_calculation())
        calc1.write_result_to_bin("bin.bin")
    except IOError as e:
        print(e)

    try:
        calc1.read_result_from_txt("txt.txt")
        print("Результат обчислення:", calc1.do_calculation())
        calc1.write_result_to_txt("txt.txt")
    except IOError as e:
        print(e)
