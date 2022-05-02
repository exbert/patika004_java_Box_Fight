public class Match {
    Fighter f1;
    Fighter f2;

    int minWeight;
    int maxWeight;
    int roundNumber = 0;
    int foeTurn = 0;

    Match( Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    public void run() {
        if (isCheck()) {
            if (whoIsFirst() >= 0.5) {
                foeTurn = 1;
                System.out.println(this.f2.name + " starts first.");
            } else {
                foeTurn = 0;
                System.out.println(this.f1.name + " starts first.");
            }
            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("=== ROUND " + this.roundNumber + "===");

                if (foeTurn == 0) {
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                } else {
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                }

                System.out.println(this.f1.name + " Health : " + this.f1.health);
                System.out.println(this.f2.name + " Health : " + this.f2.health);
                this.roundNumber++;
                /*if (foeTurn == 0) {
                    foeTurn = 1;
                } else {
                    foeTurn = 0;
                }*/
            }
        } else {
            System.out.println("Weights do not match!");
        }
    }

    boolean isCheck() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) &&
                (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " wins !");
            return true;
        }

        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " wins !");
            return true;
        }

        return false;
    }
    double whoIsFirst() {
        return Math.random();
    }
}
