<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Discount Calculator</title>
        <style>
            body { font-family: 'Arial', sans-serif; display: flex; justify-content: center; margin-top: 80px; background-color: #f8fafc; }
            .container { background: white; padding: 40px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); width: 400px; }
            h2 { color: #1b2a7a; text-align: center; }
            label { font-weight: bold; color: #333; display:block; margin-top:15px; }
            input { padding: 10px; margin: 8px 0; width: 100%; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; font-size: 15px;}
            button { background-color: #1b2a7a; color: white; padding: 12px 20px; border: none; border-radius: 4px; cursor: pointer; width: 100%; font-weight: bold; font-size: 16px; margin-top: 20px;}
            button:hover { background-color: #121c54; }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Product Discount Calculator</h2>
            <form action="display-discount" method="POST">
                <label>Product Description:</label>
                <input type="text" name="description" placeholder="Nhập mô tả sản phẩm" required />

                <label>List Price:</label>
                <input type="number" name="price" placeholder="Nhập giá niêm yết" required step="any" min="0" />

                <label>Discount Percent:</label>
                <input type="number" name="discount" placeholder="Nhập % chiết khấu" required step="any" min="0" max="100" />

                <button type="submit">Calculate Discount</button>
            </form>
        </div>
    </body>
</html>