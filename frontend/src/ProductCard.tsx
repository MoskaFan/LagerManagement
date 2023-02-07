import {ProductInfo} from "./ProductInfo";

type ProductCardProps = {
    product: ProductInfo
}
export default function ProductCard(props: ProductCardProps){
    return(
        <section>
            Product: {props.product.name}
            Quantity: {props.product.quantity}
        </section>
    )
}