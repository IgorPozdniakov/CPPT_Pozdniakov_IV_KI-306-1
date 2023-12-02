from abc import ABC, abstractmethod

class CalculateTheEquationInterface(ABC):
    @abstractmethod
    def do_calculation(self):
        pass
