public class TowerSolver {
    private TowerModel model;

    public TowerSolver() {
    }

    public void solve(TowerModel model) {
        this.model = model;
        solve(model, model.getHeight(), 0, 2);
    }

    private void solve(TowerModel model, int n, int source, int target) {
        if (n == 1) {
            model.move(source, target);
            return;
        }

        int intermediate = 3 - source - target;
        solve(model, n - 1, source, intermediate);
        model.move(source, target);
        solve(model, n - 1, intermediate, target);
    }
}
