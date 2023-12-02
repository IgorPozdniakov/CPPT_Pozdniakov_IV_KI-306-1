from Tuner import Tuner
from TV import TV

def main():
    tv = TV()
    tv.change_volume_vol_minus()
    tv.change_volume_vol_minus()
    tv.change_volume_vol_add()


    tuner = Tuner()
    tuner.include()
    tuner.change_volume_vol_minus()
    tuner.change_volume_vol_minus()
    tuner.change_volume_vol_add()
    tuner.switch_channel()

    tuner.channel_list()

if __name__ == "__main__":
    main()
