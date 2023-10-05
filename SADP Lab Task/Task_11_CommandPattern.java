interface ElectronicDevice
{
    void turnOn();
    void turnOff();
    void volumeUp();
    void volumeDown();
}

class Television implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("Television is on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Television is off.");
    }

    @Override
    public void volumeUp() {
        System.out.println("Volume up on the television.");
    }

    @Override
    public void volumeDown() {
        System.out.println("Volume down on the television.");
    }
}

class Stereo implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("Stereo is on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Stereo is off.");
    }

    @Override
    public void volumeUp() {
        System.out.println("Volume up on the stereo.");
    }

    @Override
    public void volumeDown() {
        System.out.println("Volume down on the stereo.");
    }
}

interface Command {
    void execute();
}

class TurnOnCommand implements Command {
    private ElectronicDevice device;

    public TurnOnCommand(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}

class TurnOffCommand implements Command {
    private ElectronicDevice device;

    public TurnOffCommand(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

class VolumeUpCommand implements Command {
    private ElectronicDevice device;

    public VolumeUpCommand(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.volumeUp();
    }
}

class VolumeDownCommand implements Command {
    private ElectronicDevice device;

    public VolumeDownCommand(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.volumeDown();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

class RemoteControlClient {
    public static void main(String[] args) {
        ElectronicDevice tv = new Television();
        ElectronicDevice stereo = new Stereo();

        Command turnOnTV = new TurnOnCommand(tv);
        Command volumeUpTV = new VolumeUpCommand(tv);
        Command turnOnStereo = new TurnOnCommand(stereo);
        Command volumeUpStereo = new VolumeUpCommand(stereo);

        Command turnOffTV = new TurnOffCommand(tv);
        Command volumeDownTV = new VolumeDownCommand(tv);
        Command volumeDownStereo = new VolumeDownCommand(stereo);
        Command turnOffStereo = new TurnOffCommand(stereo);

        RemoteControl remote = new RemoteControl();

        // Programming the remote control with various commands
        remote.setCommand(turnOnTV);
        remote.pressButton();

        remote.setCommand(turnOffTV);
        remote.pressButton();

        remote.setCommand(volumeUpTV);
        remote.pressButton();

        remote.setCommand(volumeDownTV);
        remote.pressButton();

        remote.setCommand(turnOnStereo);
        remote.pressButton();

        remote.setCommand(turnOffStereo);
        remote.pressButton();

        remote.setCommand(volumeUpStereo);
        remote.pressButton();

        remote.setCommand(volumeDownStereo);
        remote.pressButton();
    }
}

