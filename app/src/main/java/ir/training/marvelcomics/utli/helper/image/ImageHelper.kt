package ir.training.marvelcomics.utli.helper.image

class ImageHelper {

    companion object {

        fun getBannerUrl(
            path: String,
            extension: String,
            imageSize: ImageSize
        ): String {
            return generateThumbnailUrl(
                path = path,
                extension = extension,
                imageType = ImageType.LANDSCAPE,
                imageSize = imageSize
            )
        }

        fun getThumbnailUrl(
            path: String,
            extension: String,
            imageSize: ImageSize
        ): String {
            return generateThumbnailUrl(
                path = path,
                extension = extension,
                imageType = ImageType.PORTRAIT,
                imageSize = imageSize
            )
        }

        private fun generateThumbnailUrl(
            path: String,
            extension: String,
            imageType: ImageType,
            imageSize: ImageSize
        ): String {
            return "${path}/${imageType.value}_${imageSize.value}.$extension"
        }


    }


}