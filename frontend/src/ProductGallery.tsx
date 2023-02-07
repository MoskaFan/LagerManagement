import {ProductInfo} from "./ProductInfo";
import ProductCard from "./ProductCard";

type ProductGalleryProps = {
    products: ProductInfo[]
}
export default function ProductGallery(props: ProductGalleryProps){
    return(
        <section>
            {props.products.map(product =>(
            <ProductCard product={product} key={product.id}/>))}
        </section>
    )
}