from TvTuner import TvTuner

class TV(TvTuner):
    def __init__(self):
        self.loudness = 50
        self.switch_tv = False
        self.channel = 0
        self.fout = open("MyTvTuner.txt", "a")

    def get_fout(self):
        return self.fout

    def include(self):
        if not self.switch_tv:
            self.switch_tv = True
            print("TV is on")
            self.get_fout().write("TV is on\n")
        else:
            print("TV was already on")
            self.get_fout().write("TV was already on\n")
        self.get_fout().flush()

    def exclude(self):
        if self.switch_tv:
            self.switch_tv = False
            print("TV is off")
            self.get_fout().write("TV is off\n")
        else:
            print("TV was already off")
            self.get_fout().write("TV was already off\n")
        self.get_fout().flush()

    def change_volume_vol_add(self):
        if self.loudness <= 100:
                print("Volume TV:", self.loudness)
                self.get_fout().write("Volume TV: {}\n".format(self.loudness))
                self.loudness += 1
        else:
            print("Volume TV is maximum")
            self.get_fout().write("Volume TV is maximum\n")
        self.get_fout().flush()

    def change_volume_vol_minus(self):
        if self.loudness >= 0:
            print("Volume TV:", self.loudness)
            self.get_fout().write("Volume TV: {}\n".format(self.loudness))
            self.loudness -= 1
        else:
            print("Volume TV is minimum")
            self.get_fout().write("Volume TV is minimum\n")
        self.get_fout().flush()
