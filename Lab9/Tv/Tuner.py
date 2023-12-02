# Tuner.py
from TvTuner import TvTuner

class Tuner(TvTuner):
    def __init__(self):
        self.loudness = 90
        self.switch_tuner = False
        self.channel = 0
        self.channel_tuner = ["QTV", "NLO TV", "M1", "K1", "ICTV", "TET", "UATV"]
        self.fout = open("MyTvTuner.txt", "a")

    def get_fout(self):
        return self.fout

    def include(self):
        if not self.switch_tuner:
            self.switch_tuner = True
            print("Tuner is on")
            self.get_fout().write("Tuner is on\n")
        else:
            print("Tuner is almost on")
            self.get_fout().write("Tuner is almost on\n")
        self.get_fout().flush()

    def exclude(self):
        if self.switch_tuner:
            self.switch_tuner = False
            print("Tuner is off")
            self.get_fout().write("Tuner is off\n")
        else:
            print("Tuner was already on")
            self.get_fout().write("Tuner was already on\n")
        self.get_fout().flush()

    def change_volume_vol_add(self):
        if self.loudness <= 100:
            print("Volume of Tuner:", self.loudness)
            self.get_fout().write("Volume of Tuner: {}\n".format(self.loudness))
            self.loudness += 1
        else:
            print("Volume of Tuner is maximum")
            self.get_fout().write("Volume of Tuner is maximum\n")
        self.get_fout().flush()

    def change_volume_vol_minus(self):
        if self.loudness >= 0:
            print("Volume of Tuner:", self.loudness)
            self.get_fout().write("Volume of Tuner: {}\n".format(self.loudness))
            self.loudness -= 1
        else:
            print("Volume of Tuner is minimum")
            self.get_fout().write("Volume of Tuner is minimum\n")
        self.get_fout().flush()

    def switch_channel(self):
        if self.channel == len(self.channel_tuner):
            self.channel = 0
        print("Channel:", self.channel_tuner[self.channel])
        self.get_fout().write("Channel: {}\n".format(self.channel_tuner[self.channel]))
        self.channel += 1
        self.get_fout().flush()

    def channel_list(self):
        num = 1
        print("--<Channel list>--")
        for el in self.channel_tuner:
            print("\t{}. {}".format(num, el))
            self.get_fout().write("\t{}. {}\n".format(num, el))
            num += 1
        self.get_fout().flush()
