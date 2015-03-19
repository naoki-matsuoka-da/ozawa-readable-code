import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Recipe {
    final String RECIPE_DIR = "./recipes/";

    /**
     * 起動
     * @param args レシピ名
     */
    public static void main(String[] args) throws IOException {
        String recipeName;
        String recipeDatas[];
        Recipe recipe;

        // 引数必須
        if (args.length < 1) {
            System.out.println("ぶぶ漬け");
            return;
        }

        recipeName = args[0];
        recipe = new Recipe();
        recipeDatas = recipe.loadRecipe(recipeName);

        for (String recipeData : recipeDatas) {
            System.out.println(recipeData);
        }
    }

    /**
     * レシピファイルを読み込む
     * @param name レシピファイル名
     */
    public String[] loadRecipe(String name) throws IOException {
        BufferedReader reader;
        String loadedRecipe = "";
        String tmp;

        reader = new BufferedReader(new FileReader(getRecipePath(name)));
        while ((tmp = reader.readLine()) != null) {
            loadedRecipe += tmp + "\n";
        }

        return loadedRecipe.split("\n");
    }

    /**
     * レシピ情報ファイルのパスを取得する。
     * @param name
     * @return レシピのパス
     */
    public String getRecipePath(String name) {
        return RECIPE_DIR + name + ".txt";
    }
}