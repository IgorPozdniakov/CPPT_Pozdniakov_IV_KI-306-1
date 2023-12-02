import math
import struct
from ReadWrite import ReadWriteDataInterface
from CalctheEq import CalculateTheEquationInterface

class CalculateTheEquation(CalculateTheEquationInterface, ReadWriteDataInterface):
    def __init__(self):
        self.variable = 0

    def set_variable(self, variable):
        self.variable = variable

    def do_calculation(self):
        try:
            self.variable = math.cos(self.variable) / math.tan(2 * self.variable)
            return self.variable
        except ZeroDivisionError:
            print("Арифметична помилка: неприпустиме значення.")
            return 0

    def write_result_to_txt(self, file_name):
        with open(file_name, 'w') as file:
            file.write(f"{self.variable} ")

    def write_result_to_bin(self, file_name):
        with open(file_name, 'wb') as file:
            file.write(struct.pack('d', self.variable))

    def read_result_from_txt(self, file_name):
        try:
            with open(file_name, 'r') as file:
                self.variable = float(file.read())
        except FileNotFoundError:
            raise IOError(f"Файл {file_name} не знайдено")

    def read_result_from_bin(self, file_name):
        try:
            with open(file_name, 'rb') as file:
                self.variable = struct.unpack('d', file.read(8))[0]
        except FileNotFoundError:
            raise IOError(f"Файл {file_name} не знайдено")
