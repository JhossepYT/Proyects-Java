class Soldado {
    private String name;
    private int atkLvl;
    private int defLvl;
    private int hp;
    private int actHP;
    private int speed;
    private String actt;
    private boolean live;
    private int fila;
    private int columna;
    private int team;

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Soldado [name=" + name + ", atkLvl=" + atkLvl + ", defLvl=" + defLvl + ", hp=" + hp + ", actHP=" + actHP
                + ", speed=" + speed + ", actt=" + actt + ", live=" + live + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtkLvl() {
        return atkLvl;
    }

    public void setAtkLvl(int atkLvl) {
        this.atkLvl = atkLvl;
    }

    public int getDefLvl() {
        return defLvl;
    }

    public void setDefLvl(int defLvl) {
        this.defLvl = defLvl;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getActHP() {
        return actHP;
    }

    public void setActHP(int actHP) {
        this.actHP = actHP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getActt() {
        return actt;
    }

    public void setActt(String actt) {
        this.actt = actt;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Soldado(int y) {
        this.team = y;
        this.hp = 100;
        this.actHP = 100;
        this.speed = 1;
        this.actt = "Neutral";
        this.live = true;
    }

    public Soldado() {
        this.name = "Soldado";
        this.atkLvl = 1;
        this.defLvl = 1;
        this.hp = 100;
        this.actHP = 100;
        this.speed = 1;
        this.actt = "Neutral";
        this.live = true;
    }

    public Soldado(String name, int defLvl, int atkLvl, int hp) {
        this.name = name;
        this.atkLvl = atkLvl;
        this.defLvl = defLvl;
        this.hp = hp;
        this.actHP = hp;
        this.speed = 1;
        this.actt = "Neutral";
        this.live = true;
    }

    public Soldado(String name, int atkLvl, int defLvl, int hp, int speed, String actt, boolean live) {
        this.name = name;
        this.atkLvl = atkLvl;
        this.defLvl = defLvl;
        this.hp = 100;
        this.actHP = hp;
        this.speed = speed;
        this.actt = actt;
        this.live = live;
    }

    public void huir() {
        this.actt = "Fuga";
        this.speed += 2;
    }

    public void defender(int atkLvl) {
        this.actt = "Defensive";
        this.speed = 0;
        if (this.defLvl < atkLvl) {
            this.actHP = this.actHP - (atkLvl - this.defLvl);
            this.defLvl = 0;
            if (this.actHP <= 0) {
                this.live = false;
            }
        }
    }

    public void morir() {
        this.actHP = 0;
        this.live = false;

    }

    public void attack(Soldado b) {
        if (this.atkLvl / 2 > b.getDefLvl()) {
            if (b.getSpeed() > this.speed) {
                b.huir();
            } else {
                b.defender(this.atkLvl);
            }
        } else {
            this.actt = "Offensive";
            this.speed += 1;
            if (b.getDefLvl() >= this.atkLvl) {
                System.out.println("Contrataque causa"); // Depuration msg
                if (this.defLvl >= b.getAtkLvl()) {
                    this.actt = "Defensive";
                    this.speed = 0;
                    b.attack(this);
                } else {
                    System.out.println("xD"); // Depuration msg
                    b.setActt("Offensive");
                    this.defender(b.getAtkLvl());
                    b.setSpeed(b.getSpeed() + 1);
                }
            }
        }
    }
}