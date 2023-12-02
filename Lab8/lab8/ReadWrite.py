from abc import ABC, abstractmethod

class ReadWriteDataInterface(ABC):
    @abstractmethod
    def write_result_to_txt(self, file_name):
        pass

    @abstractmethod
    def write_result_to_bin(self, file_name):
        pass

    @abstractmethod
    def read_result_from_txt(self, file_name):
        pass

    @abstractmethod
    def read_result_from_bin(self, file_name):
        pass
